package codeping.flex.stock.adapter.out;

import codeping.flex.stock.adapter.out.entity.StockEntity;
import codeping.flex.stock.adapter.out.entity.repository.StockRepository;
import codeping.flex.stock.application.port.out.LoadStockPort;
import codeping.flex.stock.global.StockErrorCode;
import codeping.flex.stock.global.common.exception.ApplicationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoadStockAdapter implements LoadStockPort {
    private final StockRepository stockRepository;

    @Override
    public StockEntity getStock(String stockcode) {
        return stockRepository.findByStockcode(stockcode).orElseThrow(
                ()-> ApplicationException.from(StockErrorCode.STOCK_NOT_FOUND));
    }
}
