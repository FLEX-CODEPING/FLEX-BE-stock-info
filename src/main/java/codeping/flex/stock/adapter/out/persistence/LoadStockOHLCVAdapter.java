package codeping.flex.stock.adapter.out.persistence;

import codeping.flex.stock.adapter.out.persistence.entity.pk.StockIDEntity;
import codeping.flex.stock.adapter.out.persistence.mapper.StockOHLCVMapper;
import codeping.flex.stock.adapter.out.persistence.repository.StockOHLCVRepository;
import codeping.flex.stock.application.port.out.LoadStockOHLCVPort;
import codeping.flex.stock.domain.StockOHLCV;
import codeping.flex.stock.global.annotation.architecture.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class LoadStockOHLCVAdapter implements LoadStockOHLCVPort {
    private final StockOHLCVRepository stockOHLCVRepository;
    private final StockOHLCVMapper stockOHLCVMapper;

    @Override
    public Optional<StockOHLCV> loadByStockCodeAndDate(StockIDEntity stockID) {
        return stockOHLCVRepository.findById(stockID)
                .map(stockOHLCVMapper::toDomain);
    }
}
