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

    private String corpName;

    private String stockCode;

    @Builder
    public InterestStock(Long userId, String corpName, String stockCode) {
        this.userId = userId;
        this.corpName = corpName;
        this.stockCode = stockCode;
    }
}
