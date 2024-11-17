package codeping.flex.stock.application.port.out;

import codeping.flex.stock.adapter.out.persistense.entity.StockOHLCVEntity;
import codeping.flex.stock.adapter.out.persistense.entity.pk.StockIDEntity;

public interface LoadStockOHLCVPort {
    StockOHLCVEntity loadStockOHLCV(StockIDEntity stockID);
}
