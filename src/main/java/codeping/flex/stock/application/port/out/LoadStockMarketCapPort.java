package codeping.flex.stock.application.port.out;


import codeping.flex.stock.adapter.out.persistence.entity.stockData.pk.StockIDEntity;
import codeping.flex.stock.domain.stockData.StockMarketCap;

import java.util.Optional;

public interface LoadStockMarketCapPort {
    Optional<StockMarketCap> loadByStockCodeAndDate(StockIDEntity stockIDEntity);
}
