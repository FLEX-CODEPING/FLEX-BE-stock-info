package codeping.flex.stock.application.port.out;


import codeping.flex.stock.adapter.out.persistense.entity.pk.StockIDEntity;
import codeping.flex.stock.domain.StockMarketCap;

public interface LoadStockMarketCapPort {
    StockMarketCap loadStockMarketCap(StockIDEntity stockIDEntity);
}
