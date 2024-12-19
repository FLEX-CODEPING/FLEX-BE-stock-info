package codeping.flex.stock.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InterestStock {
    private Long id;

    private Long userId;

    private String stockName;

    private String stockcode;

    @Builder
    public InterestStock(Long id, Long userId, String stockName, String stockcode) {
        this.id = id;
        this.userId = userId;
        this.stockName = stockName;
        this.stockcode = stockcode;
    }
}
