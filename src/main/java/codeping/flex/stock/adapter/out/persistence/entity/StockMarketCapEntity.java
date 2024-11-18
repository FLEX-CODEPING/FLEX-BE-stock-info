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
@Table(name = "stock_market_cap")
public class StockMarketCapEntity {

    @EmbeddedId
    private StockIDEntity stockIDEntity;

    @Column(name = "market_cap")
    private Long marketCap;

    @Column
    private Long volume;

    @Column(name = "trading_value")
    private Long tradingValue;

    @Column(name = "listed_shares")
    private Long listedShares;
}