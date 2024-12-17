package codeping.flex.stock.application.port.out;

import codeping.flex.stock.domain.Stock;

import java.util.List;
import java.util.Optional;

public interface LoadStockPort {
    Optional<Stock> loadByStockCode(String stockcode);
    List<Stock> loadByStockCodes(List<String> stockcodes);
}
