package codeping.flex.stock.application;

import codeping.flex.stock.application.mapper.GetStockImageDtoMapper;
import codeping.flex.stock.application.port.in.StockImageUsecase;
import codeping.flex.stock.application.port.in.dto.GetStockImageDto;
import codeping.flex.stock.application.port.out.LoadStockPort;
import codeping.flex.stock.global.annotation.architecture.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ApplicationService
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StockImageService implements StockImageUsecase {
    private final LoadStockPort loadStockPort;
    private final GetStockImageDtoMapper stockImageDtoMapper;

    @Override
    public List<GetStockImageDto> getStockImageUrls(List<String> stockcodes) {
        return loadStockPort.loadByStockCodes(stockcodes)
                .stream().map(stockImageDtoMapper::toGetStockImageDto).toList();

    }
}
