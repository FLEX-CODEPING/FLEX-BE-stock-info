package codeping.flex.stock.adapter.out.persistense;

import codeping.flex.stock.adapter.out.persistense.entity.StockEntity;
import codeping.flex.stock.adapter.out.persistense.entity.repository.StockRepository;
import codeping.flex.stock.application.port.out.LoadStockPort;
import codeping.flex.stock.global.StockErrorCode;
import codeping.flex.stock.global.annotation.architecture.PersistenceAdapter;
import codeping.flex.stock.global.common.exception.ApplicationException;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class LoadStockAdapter implements LoadStockPort {
    private final StockRepository stockRepository;

    @Override
    public StockEntity loadStock(String stockcode) {
        return stockRepository.findByStockcode(stockcode).orElseThrow(
                ()-> ApplicationException.from(StockErrorCode.STOCK_NOT_FOUND));
    }
}
