package codeping.flex.stock.domain.stockData;

public record StockDocumentDomain(
        String stockcode,
        String stockName,
        String market
) {}
