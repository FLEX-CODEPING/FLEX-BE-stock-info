package codeping.flex.stock.domain.stockData;

public record StockMarketCap(
        StockID stockID,
        Long marketCap,
        Long volume,
        Long tradingValue,
        Long listedShares,
        Stock stock
) {}