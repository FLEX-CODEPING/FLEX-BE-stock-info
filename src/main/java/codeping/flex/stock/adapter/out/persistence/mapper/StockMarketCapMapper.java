package codeping.flex.stock.adapter.out.persistence.mapper;

import codeping.flex.stock.adapter.out.persistence.entity.StockMarketCapEntity;
import codeping.flex.stock.adapter.out.persistence.mapper.common.ReadOnlyEntityMapper;
import codeping.flex.stock.domain.StockMarketCap;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {StockIDMapper.class}, disableSubMappingMethodsGeneration = true)
public interface StockMarketCapMapper extends ReadOnlyEntityMapper<StockMarketCapEntity, StockMarketCap> {
    @Override
    @Mapping(target = "stockID", source = "stockID")
    StockMarketCap toDomain(StockMarketCapEntity entity);
}