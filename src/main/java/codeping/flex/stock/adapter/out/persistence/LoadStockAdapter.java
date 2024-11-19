package codeping.flex.stock.adapter.out.persistence;

import codeping.flex.stock.adapter.out.persistence.entity.StockEntity;
import codeping.flex.stock.adapter.out.persistence.mapper.StockMapper;
import codeping.flex.stock.adapter.out.persistence.repository.StockRepository;
import codeping.flex.stock.application.port.out.LoadStockPort;
import codeping.flex.stock.domain.Stock;
import codeping.flex.stock.global.StockErrorCode;
import codeping.flex.stock.global.annotation.architecture.PersistenceAdapter;
import codeping.flex.stock.global.common.exception.ApplicationException;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class LoadStockAdapter implements LoadStockPort {
    private final StockRepository stockRepository;
    private final StockMapper stockMapper;

    @Override
    public Stock loadByStockCode(String stockcode) {
        StockEntity entity = stockRepository.findByStockcode(stockcode).orElseThrow(
                ()-> ApplicationException.from(StockErrorCode.STOCK_NOT_FOUND));
        return stockMapper.toDomain(entity);
    }
}
