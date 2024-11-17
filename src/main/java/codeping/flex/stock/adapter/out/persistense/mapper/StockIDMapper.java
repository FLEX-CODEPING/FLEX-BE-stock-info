package codeping.flex.stock.adapter.out.persistense.mapper;

import codeping.flex.stock.adapter.out.persistense.entity.pk.StockIDEntity;
import codeping.flex.stock.domain.StockID;

public class StockIDMapper {
    private StockIDMapper() {
        throw new IllegalStateException("Util Class");
    }

    public static StockID toDomain(StockIDEntity entity) {
        return StockID.builder()
                .stockcode(entity.getStockcode())
                .date(entity.getDate())
                .build();
    }

    public static StockIDEntity toEntity(StockID domain) {
        return StockIDEntity.builder()
                .stockcode(domain.getStockcode())
                .date(domain.getDate())
                .build();
    }
}
