package codeping.flex.stock.domain.stockData;

public record StockOHLCV(
        StockID stockID,
        Float openPrice,
        Float highPrice,
        Float lowPrice,
        Float closePrice,
        Long volume,
        Float changeRate,
        Stock stock
) {}