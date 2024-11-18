package codeping.flex.stock.application.port.out;

import codeping.flex.stock.adapter.out.persistence.entity.StockOHLCVEntity;
import codeping.flex.stock.adapter.out.persistence.entity.pk.StockIDEntity;

public interface LoadStockOHLCVPort {
    StockOHLCVEntity loadStockOHLCV(StockIDEntity stockID);
}
