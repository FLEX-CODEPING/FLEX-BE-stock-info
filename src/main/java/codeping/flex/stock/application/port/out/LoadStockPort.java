package codeping.flex.stock.application.port.out;

import codeping.flex.stock.adapter.out.entity.StockEntity;

public interface LoadStockPort {
    StockEntity getStock(String stockcode);
}
