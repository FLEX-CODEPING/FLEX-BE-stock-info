package codeping.flex.stock.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public final class StockOHLCV {

    private StockID stockID;

    private Float openPrice;

    private Float highPrice;

    private Float lowPrice;

    private Float closePrice;

    private Long volume;

    private Float changeRate;

    private Stock ticker;
}