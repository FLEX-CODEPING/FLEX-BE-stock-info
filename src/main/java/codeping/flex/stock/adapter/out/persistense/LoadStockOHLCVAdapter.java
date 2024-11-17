package codeping.flex.stock.adapter.out.persistense;

import codeping.flex.stock.adapter.out.persistense.entity.StockOHLCVEntity;
import codeping.flex.stock.adapter.out.persistense.entity.pk.StockIDEntity;
import codeping.flex.stock.adapter.out.persistense.entity.repository.StockOHLCVRepository;
import codeping.flex.stock.application.port.out.LoadStockOHLCVPort;
import codeping.flex.stock.global.StockErrorCode;
import codeping.flex.stock.global.annotation.architecture.PersistenceAdapter;
import codeping.flex.stock.global.common.exception.ApplicationException;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class LoadStockOHLCVAdapter implements LoadStockOHLCVPort {
    private final StockOHLCVRepository stockOHLCVRepository;

    @Override
    public StockOHLCVEntity loadStockOHLCV(StockIDEntity stockID) {
        return stockOHLCVRepository.findById(stockID).orElseThrow(
                ()-> ApplicationException.from(StockErrorCode.STOCK_OHLCV_NOT_FOUND));
    }
}
