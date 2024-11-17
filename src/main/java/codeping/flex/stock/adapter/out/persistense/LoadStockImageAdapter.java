package codeping.flex.stock.adapter.out.persistense;

import codeping.flex.stock.adapter.out.persistense.entity.StockImageEntity;
import codeping.flex.stock.adapter.out.persistense.entity.repository.StockImageRepository;
import codeping.flex.stock.application.port.out.LoadStockImagePort;
import codeping.flex.stock.global.annotation.architecture.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class LoadStockImageAdapter implements LoadStockImagePort {
    private final StockImageRepository stockImageRepository;

    @Override
    public StockImageEntity loadStockImage(String stockcode) {
        return stockImageRepository.findByStockcode(stockcode).orElse(null);
    }
}
