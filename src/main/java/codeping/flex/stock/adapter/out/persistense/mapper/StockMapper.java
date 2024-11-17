package codeping.flex.stock.adapter.out.persistense.mapper;

import codeping.flex.stock.adapter.out.persistense.entity.StockEntity;
import codeping.flex.stock.domain.Stock;

public class StockMapper {
    private StockMapper() {
        throw new IllegalStateException("Util Class");
    }

    public static Stock toDomain(StockEntity entity) {
        return Stock.builder()
                .stockcode(entity.getStockcode())
                .corpName(entity.getCorpName())
                .market(entity.getMarket())
                .build();
    }
}
