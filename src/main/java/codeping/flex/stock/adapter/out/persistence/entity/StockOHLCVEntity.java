package codeping.flex.stock.adapter.out.persistence.entity;

import codeping.flex.stock.adapter.out.persistence.entity.pk.StockIDEntity;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "stock_ohlcv")
public class StockOHLCVEntity {

    @EmbeddedId
    private StockIDEntity stockIDEntity;

    @Column
    private Float openPrice;

    @Column
    private Float highPrice;

    @Column
    private Float lowPrice;

    @Column
    private Float closePrice;

    @Column
    private Long volume;

    @Column(name = "change_rate")
    private Float changeRate;
}