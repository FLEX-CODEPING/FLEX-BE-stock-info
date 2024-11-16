package codeping.flex.stock.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public final class StockImage {

    private String stockcode;

    private String imageUrl;
}
