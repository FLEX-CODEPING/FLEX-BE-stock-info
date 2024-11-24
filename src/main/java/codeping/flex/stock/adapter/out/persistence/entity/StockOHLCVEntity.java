package codeping.flex.stock.adapter.out.persistence.entity;

import codeping.flex.stock.adapter.out.persistence.entity.pk.StockIDEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "stock_ohlcv")
public class StockOHLCVEntity {

    @EmbeddedId
    private StockIDEntity stockID;

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

    @ManyToOne
    @JoinColumn(name = "ticker", referencedColumnName = "stockcode", insertable = false, updatable = false)
    private StockEntity ticker;
}