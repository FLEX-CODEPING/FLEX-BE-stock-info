package codeping.flex.stock.application;

import codeping.flex.stock.adapter.out.persistence.mapper.InterestStockMapper;
import codeping.flex.stock.application.port.in.InterestStockUsecase;
import codeping.flex.stock.application.port.out.InterestStockPort;
import codeping.flex.stock.application.port.out.LoadStockPort;
import codeping.flex.stock.domain.InterestStock;
import codeping.flex.stock.domain.Stock;
import codeping.flex.stock.domain.execption.StockErrorCode;
import codeping.flex.stock.global.annotation.architecture.ApplicationService;
import codeping.flex.stock.global.common.exception.ApplicationException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@ApplicationService
public class InterestStockService implements InterestStockUsecase {
    private final InterestStockPort interestStockPort;
    private final InterestStockMapper interestStockMapper;
    private final LoadStockPort loadStockPort;

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

}
