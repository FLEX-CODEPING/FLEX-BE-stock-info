package codeping.flex.stock.application.port.out;

import codeping.flex.stock.adapter.out.persistence.entity.StockEntity;

public interface LoadStockPort {
    StockEntity loadStock(String stockcode);
}
