package codeping.flex.stock.application.port.out;

import codeping.flex.stock.adapter.out.entity.StockOHLCVEntity;
import codeping.flex.stock.adapter.out.entity.pk.StockIDEntity;

public interface LoadStockOHLCVPort {
    StockOHLCVEntity getStockOHLCV(StockIDEntity stockID);
}
