package codeping.flex.stock.adapter.out.mapper;

import codeping.flex.stock.adapter.out.entity.StockMarketCapEntity;
import codeping.flex.stock.domain.StockMarketCap;

public class StockMarketCapMapper {
    private StockMarketCapMapper() {
        throw new IllegalStateException("Util Class");
    }

    public static StockMarketCap toDomain(StockMarketCapEntity entity) {
        return StockMarketCap.builder()
                .stockID(StockIDMapper.toDomain(entity.getStockIDEntity()))
                .marketCap(entity.getMarketCap())
                .volume(entity.getVolume())
                .tradingValue(entity.getTradingValue())
                .listedShares(entity.getListedShares())
                .build();
    }
}