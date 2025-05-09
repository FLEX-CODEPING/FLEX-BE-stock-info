package codeping.flex.stock.adapter.out.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "stock")
public class StockEntity {
    @Id
    @Column(length = 50)
    private String stockcode;

    @Column(length = 50)
    private String stockName;

    @Column(length = 50)
    private String market;

    @Column
    private String imageUrl;
}
