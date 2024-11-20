package codeping.flex.stock.application.port.out;

import codeping.flex.stock.domain.StockImage;

import java.util.Optional;

public interface LoadStockImagePort {
    Optional<StockImage> loadByStockCode(String stockcode);
}
