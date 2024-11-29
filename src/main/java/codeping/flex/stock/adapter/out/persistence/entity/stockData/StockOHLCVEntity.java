package codeping.flex.stock.adapter.out.persistence.entity.stockData;

import codeping.flex.stock.adapter.out.persistence.entity.stockData.pk.StockIDEntity;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_id", referencedColumnName = "stockcode", insertable = false, updatable = false)
    private StockEntity stock;
}