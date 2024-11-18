package codeping.flex.stock.adapter.out.persistence.mapper;

import codeping.flex.stock.adapter.out.persistence.entity.StockImageEntity;
import codeping.flex.stock.domain.StockImage;

public class StockImageMapper {
    private StockImageMapper() {
        throw new IllegalStateException("Util Class");
    }

    public static StockImage toDomain(StockImageEntity entity) {
        return StockImage.builder()
                .stockcode(entity.getStockcode())
                .imageUrl(entity.getImageUrl())
                .build();
    }
}
