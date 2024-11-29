package codeping.flex.stock.application.port.out;

import codeping.flex.stock.adapter.out.persistence.entity.stockData.pk.StockIDEntity;
import codeping.flex.stock.domain.stockData.StockOHLCV;

import java.util.Optional;

public interface LoadStockOHLCVPort {
    Optional<StockOHLCV> loadByStockCodeAndDate(StockIDEntity stockID);
}
