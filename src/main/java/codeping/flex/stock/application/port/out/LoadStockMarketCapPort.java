package codeping.flex.stock.application.port.out;


import codeping.flex.stock.adapter.out.persistence.entity.pk.StockIDEntity;
import codeping.flex.stock.domain.StockMarketCap;

public interface LoadStockMarketCapPort {
    StockMarketCap loadStockMarketCap(StockIDEntity stockIDEntity);
}
