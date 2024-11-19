package codeping.flex.stock.adapter.out.persistence;

import codeping.flex.stock.adapter.out.persistence.entity.StockImageEntity;
import codeping.flex.stock.adapter.out.persistence.mapper.StockImageMapper;
import codeping.flex.stock.adapter.out.persistence.repository.StockImageRepository;
import codeping.flex.stock.application.port.out.LoadStockImagePort;
import codeping.flex.stock.domain.StockImage;
import codeping.flex.stock.global.annotation.architecture.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class LoadStockImageAdapter implements LoadStockImagePort {
    private final StockImageRepository stockImageRepository;
    private final StockImageMapper stockImageMapper;

    @Override
    public StockImage loadByStockCode(String stockcode) {
        StockImageEntity entity = stockImageRepository.findByStockcode(stockcode).orElse(null);
        return stockImageMapper.toDomain(entity);
    }
}
