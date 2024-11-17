package codeping.flex.stock.adapter.out.persistense.entity;

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
@Table(name = "stock_image")
public class StockImageEntity {

    @Id
    @Column(length = 50)
    private String stockcode;

    @Column
    private String imageUrl;
}
