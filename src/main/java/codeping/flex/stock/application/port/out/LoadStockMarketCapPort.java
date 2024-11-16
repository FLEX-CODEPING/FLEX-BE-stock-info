package codeping.flex.stock.application.port.out;


import codeping.flex.stock.adapter.out.entity.pk.StockIDEntity;
import codeping.flex.stock.domain.StockMarketCap;

public interface LoadStockMarketCapPort {
    StockMarketCap getStockMarketCap(StockIDEntity stockIDEntity);
}
