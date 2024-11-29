package codeping.flex.stock.application.port.out;

import codeping.flex.stock.domain.stockData.Stock;

import java.util.Optional;

public interface LoadStockPort {
    Optional<Stock> loadByStockCode(String stockcode);
}
