package codeping.flex.stock.adapter.out.persistence;

import codeping.flex.stock.adapter.out.persistence.entity.stockData.pk.StockIDEntity;
import codeping.flex.stock.adapter.out.persistence.mapper.StockMarketCapMapper;
import codeping.flex.stock.adapter.out.persistence.repository.StockMarketCapRepository;
import codeping.flex.stock.application.port.out.LoadStockMarketCapPort;
import codeping.flex.stock.domain.stockData.StockMarketCap;
import codeping.flex.stock.global.annotation.architecture.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class LoadStockMarketCapAdapter implements LoadStockMarketCapPort {
    private final StockMarketCapRepository stockMarketCapRepository;
    private final StockMarketCapMapper stockMarketCapMapper;

    @Override
    public Optional<StockMarketCap> loadByStockCodeAndDate(StockIDEntity stockIDEntity) {
        return stockMarketCapRepository.findById(stockIDEntity)
                .map(stockMarketCapMapper::toDomain);
    }
}
