package codeping.flex.stock.domain.stockData;

import java.time.LocalDate;

public record StockID(
        String stockcode,
        LocalDate date
) {}
