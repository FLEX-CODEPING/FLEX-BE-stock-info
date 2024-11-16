package codeping.flex.stock.adapter.out;

import codeping.flex.stock.adapter.out.entity.StockOHLCVEntity;
import codeping.flex.stock.adapter.out.entity.pk.StockIDEntity;
import codeping.flex.stock.adapter.out.entity.repository.StockOHLCVRepository;
import codeping.flex.stock.application.port.out.LoadStockOHLCVPort;
import codeping.flex.stock.global.StockErrorCode;
import codeping.flex.stock.global.common.exception.ApplicationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoadStockOHLCVAdapter implements LoadStockOHLCVPort {
    private final StockOHLCVRepository stockOHLCVRepository;

    @Override
    public StockOHLCVEntity getStockOHLCV(StockIDEntity stockID) {
        return stockOHLCVRepository.findById(stockID).orElseThrow(
                ()-> ApplicationException.from(StockErrorCode.STOCK_OHLCV_NOT_FOUND));
    }
}
