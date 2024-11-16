package codeping.flex.stock.application.port.out;


import codeping.flex.stock.domain.StockID;
import codeping.flex.stock.domain.StockMarketCap;

public interface LoadStockMarketCapPort {
    StockMarketCap getStockMarketCap(StockID stockID);
}
