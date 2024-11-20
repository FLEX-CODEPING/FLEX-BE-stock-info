package codeping.flex.stock.application;

import codeping.flex.stock.adapter.out.persistence.mapper.InterestStockMapper;
import codeping.flex.stock.application.mapper.GetInterestStockResponseMapper;
import codeping.flex.stock.application.port.in.InterestStockUsecase;
import codeping.flex.stock.application.port.in.dto.GetInterestStockInfoDto;
import codeping.flex.stock.application.port.out.InterestStockPort;
import codeping.flex.stock.application.port.out.LoadStockImagePort;
import codeping.flex.stock.application.port.out.LoadStockPort;
import codeping.flex.stock.domain.InterestStock;
import codeping.flex.stock.domain.Stock;
import codeping.flex.stock.domain.StockImage;
import codeping.flex.stock.domain.execption.StockErrorCode;
import codeping.flex.stock.global.annotation.architecture.ApplicationService;
import codeping.flex.stock.global.common.exception.ApplicationException;
import codeping.flex.stock.global.common.response.SliceResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@ApplicationService
public class InterestStockService implements InterestStockUsecase {
    private final InterestStockPort interestStockPort;
    private final InterestStockMapper interestStockMapper;
    private final LoadStockPort loadStockPort;
    private final LoadStockImagePort loadStockImagePort;
    private final GetInterestStockResponseMapper getInterestStockResponseMapper;

    @Override
    @Transactional
    public void addInterest(String stockCode, Long userId) {
        if(interestStockPort.existsByStockcodeAndUserId(stockCode, userId)){
            throw ApplicationException.from(StockErrorCode.DUPLICATE_INTEREST_STOCK);
        };
        Stock stock = loadStockPort.loadByStockCode(stockCode).orElseThrow(
                () -> ApplicationException.from(StockErrorCode.STOCK_NOT_FOUND)
        );
        InterestStock interestStock = interestStockMapper.toDomain(stock, userId);
        interestStockPort.save(interestStock);
    }

    @Override
    @Transactional
    public void removeInterest(Long interestStockId, Long userId) {
        if(!interestStockPort.existsByIdAndUserId(interestStockId, userId)){
            throw ApplicationException.from(StockErrorCode.INTEREST_STOCK_BAD_REQUEST);
        }
        interestStockPort.deleteById(interestStockId);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean getIsInterest(String stockCode, Long userId) {
        return interestStockPort.existsByStockcodeAndUserId(stockCode, userId);
    }

    @Override
    public SliceResponse<GetInterestStockInfoDto> getInterestStocks(Long userId, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);

        Slice<InterestStock> interestStockSlice = interestStockPort.findByUserId(userId, pageRequest);
        List<InterestStock> interestStocks = interestStockSlice.getContent();
        List<StockImage>  stockImages= loadStockImagePort.loadAllByStockCode(interestStocks.stream().map(InterestStock::getStockcode).toList());

        List<GetInterestStockInfoDto> response = getInterestStockResponseMapper.toDtoList(interestStocks, stockImages);
        return SliceResponse.of(response, interestStockSlice.hasNext(), interestStockSlice.isFirst(), interestStockSlice.isLast());
    }

}
