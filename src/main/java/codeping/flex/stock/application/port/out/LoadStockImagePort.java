package codeping.flex.stock.application.port.out;

import codeping.flex.stock.adapter.out.persistence.entity.StockImageEntity;

public interface LoadStockImagePort {
    StockImageEntity loadStockImage(String stockcode);
}
