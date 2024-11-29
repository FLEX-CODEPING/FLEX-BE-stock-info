package codeping.flex.stock.domain.stockData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public final class Stock {
    private String stockcode;

    private String stockName;

    private String market;

    private String imageUrl;

    public String getFormattedMarket() {
        return switch (market) {
            case "KOSPI" -> "코스피";
            case "KOSDAQ" -> "코스닥";
            default -> market;
        };
    }
}