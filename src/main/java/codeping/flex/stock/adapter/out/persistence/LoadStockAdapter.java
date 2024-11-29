package codeping.flex.stock.adapter.out.persistence;

import codeping.flex.stock.adapter.out.persistence.mapper.StockMapper;
import codeping.flex.stock.adapter.out.persistence.repository.StockRepository;
import codeping.flex.stock.application.port.out.LoadStockPort;
import codeping.flex.stock.domain.stockData.Stock;
import codeping.flex.stock.global.annotation.architecture.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class LoadStockAdapter implements LoadStockPort {
    private final StockRepository stockRepository;
    private final StockMapper stockMapper;

    @Override
    public Optional<Stock> loadByStockCode(String stockcode) {
        return stockRepository.findByStockcode(stockcode)
                .map(stockMapper::toDomain);
    }
}
