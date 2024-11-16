package codeping.flex.stock.adapter.out.mapper;

import codeping.flex.stock.adapter.out.entity.StockEntity;
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
