package codeping.flex.stock.application.port.out;


import codeping.flex.stock.adapter.out.persistence.entity.pk.StockIDEntity;
import codeping.flex.stock.domain.StockMarketCap;

import java.util.Optional;

public interface LoadStockMarketCapPort {
    Optional<StockMarketCap> loadByStockCodeAndDate(StockIDEntity stockIDEntity);
}
