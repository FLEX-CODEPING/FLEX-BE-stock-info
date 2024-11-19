package codeping.flex.stock.adapter.out.persistence;

import codeping.flex.stock.adapter.out.persistence.entity.StockMarketCapEntity;
import codeping.flex.stock.adapter.out.persistence.entity.pk.StockIDEntity;
import codeping.flex.stock.adapter.out.persistence.repository.StockMarketCapRepository;
import codeping.flex.stock.adapter.out.persistence.mapper.StockMarketCapMapper;
import codeping.flex.stock.application.port.out.LoadStockMarketCapPort;
import codeping.flex.stock.domain.StockMarketCap;
import codeping.flex.stock.global.StockErrorCode;
import codeping.flex.stock.global.annotation.architecture.PersistenceAdapter;
import codeping.flex.stock.global.common.exception.ApplicationException;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class LoadStockMarketCapAdapter implements LoadStockMarketCapPort {
    private final StockMarketCapRepository stockMarketCapRepository;
    private final StockMarketCapMapper stockMarketCapMapper;

    @Override
    public StockMarketCap loadByStockCodeAndDate(StockIDEntity stockIDEntity) {
        StockMarketCapEntity entity = stockMarketCapRepository.findById(stockIDEntity)
                .orElseThrow(() -> ApplicationException.from(StockErrorCode.STOCK_MARKET_CAP_NOT_FOUND));
        return stockMarketCapMapper.toDomain(entity);
    }
}
