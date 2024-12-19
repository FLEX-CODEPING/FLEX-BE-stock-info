package codeping.flex.stock.adapter.out.persistence.entity;

import codeping.flex.stock.adapter.out.persistence.entity.pk.StockIDEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "stock_market_cap")
public class StockMarketCapEntity {

    @EmbeddedId
    private StockIDEntity stockID;

    @Column(name = "market_cap")
    private Long marketCap;

    @Column
    private Long volume;

    @Column(name = "trading_value")
    private Long tradingValue;

    @Column(name = "listed_shares")
    private Long listedShares;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_id", referencedColumnName = "stockcode", insertable = false, updatable = false)
    private StockEntity stock;
}