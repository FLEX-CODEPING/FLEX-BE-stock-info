package codeping.flex.stock.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public final class StockMarketCap {
    private StockID stockID;

    private Long marketCap;

    private Long volume;

    private Long tradingValue;

    private Long listedShares;

    private Stock stock;
}
