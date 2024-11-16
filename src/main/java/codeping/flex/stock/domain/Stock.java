package codeping.flex.stock.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public final class Stock {
    private String stockcode;

    private String corpName;

    private String market;
}
