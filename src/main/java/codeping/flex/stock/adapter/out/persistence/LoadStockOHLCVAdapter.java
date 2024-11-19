package codeping.flex.stock.adapter.out.persistence;

import codeping.flex.stock.adapter.out.persistence.entity.StockOHLCVEntity;
import codeping.flex.stock.adapter.out.persistence.entity.pk.StockIDEntity;
import codeping.flex.stock.adapter.out.persistence.mapper.StockOHLCVMapper;
import codeping.flex.stock.adapter.out.persistence.repository.StockOHLCVRepository;
import codeping.flex.stock.application.port.out.LoadStockOHLCVPort;
import codeping.flex.stock.domain.StockOHLCV;
import codeping.flex.stock.global.StockErrorCode;
import codeping.flex.stock.global.annotation.architecture.PersistenceAdapter;
import codeping.flex.stock.global.common.exception.ApplicationException;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class LoadStockOHLCVAdapter implements LoadStockOHLCVPort {
    private final StockOHLCVRepository stockOHLCVRepository;
    private final StockOHLCVMapper stockOHLCVMapper;

    @Override
    public StockOHLCV loadByStockCodeAndDate(StockIDEntity stockID) {
        StockOHLCVEntity entity = stockOHLCVRepository.findById(stockID).orElseThrow(
                ()-> ApplicationException.from(StockErrorCode.STOCK_OHLCV_NOT_FOUND));
        return stockOHLCVMapper.toDomain(entity);
    }
}
