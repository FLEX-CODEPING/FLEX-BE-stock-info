package codeping.flex.stock.domain.stockData;

public record Stock(
        String stockcode,
        String stockName,
        String market,
        String imageUrl
) {
}
