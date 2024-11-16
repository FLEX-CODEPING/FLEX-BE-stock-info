package codeping.flex.stock.application.port.out;

import codeping.flex.stock.adapter.out.entity.StockOHLCVEntity;
import codeping.flex.stock.domain.StockID;

public interface LoadStockOHLCVPort {
    StockOHLCVEntity getStockOHLCV(StockID stockID);
}
