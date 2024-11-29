package codeping.flex.stock.adapter.out.persistence.entity.interest;

import codeping.flex.stock.adapter.out.persistence.entity.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "interest_stock")
public class InterestStockEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String stockName;

    @Column(nullable = false)
    private String stockcode;

    @Builder
    public InterestStockEntity(Long userId, String stockName, String stockcode) {
        this.userId = userId;
        this.stockName = stockName;
        this.stockcode = stockcode;
    }
}
