package codeping.flex.stock.adapter.out;

import codeping.flex.stock.adapter.out.entity.StockMarketCapEntity;
import codeping.flex.stock.adapter.out.entity.pk.StockIDEntity;
import codeping.flex.stock.adapter.out.entity.repository.StockMarketCapRepository;
import codeping.flex.stock.adapter.out.mapper.StockMarketCapMapper;
import codeping.flex.stock.application.port.out.LoadStockMarketCapPort;
import codeping.flex.stock.domain.StockMarketCap;
import codeping.flex.stock.global.StockErrorCode;
import codeping.flex.stock.global.common.exception.ApplicationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoadStockMarketCapAdapter implements LoadStockMarketCapPort {
    private final StockMarketCapRepository stockMarketCapRepository;

    @Override
    public StockMarketCap getStockMarketCap(StockIDEntity stockIDEntity) {
        StockMarketCapEntity entity = stockMarketCapRepository.findById(stockIDEntity)
                .orElseThrow(() -> ApplicationException.from(StockErrorCode.STOCK_MARKET_CAP_NOT_FOUND));
        return StockMarketCapMapper.toDomain(entity);
    }
}
