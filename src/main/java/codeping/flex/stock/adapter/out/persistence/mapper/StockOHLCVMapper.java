package codeping.flex.stock.adapter.out.persistence.mapper;

import codeping.flex.stock.adapter.out.persistence.entity.StockOHLCVEntity;
import codeping.flex.stock.domain.StockOHLCV;

public class StockOHLCVMapper {
    private StockOHLCVMapper() {
        throw new IllegalStateException("Util Class");
    }

    public static StockOHLCV toDomain(StockOHLCVEntity entity) {
        return StockOHLCV.builder()
                .stockID(StockIDMapper.toDomain(entity.getStockIDEntity()))
                .openPrice(entity.getOpenPrice())
                .highPrice(entity.getHighPrice())
                .lowPrice(entity.getLowPrice())
                .closePrice(entity.getClosePrice())
                .volume(entity.getVolume())
                .changeRate(entity.getChangeRate())
                .build();
    }
}