package codeping.flex.stock.adapter.out.persistence.mapper;

import codeping.flex.stock.adapter.out.persistence.entity.StockOHLCVEntity;
import codeping.flex.stock.adapter.out.persistence.mapper.common.ReadOnlyEntityMapper;
import codeping.flex.stock.domain.StockOHLCV;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {StockIDMapper.class,  StockMapper.class}, disableSubMappingMethodsGeneration = true)
public interface StockOHLCVMapper extends ReadOnlyEntityMapper<StockOHLCVEntity, StockOHLCV> {
    StockOHLCVMapper INSTANCE = Mappers.getMapper(StockOHLCVMapper.class);

    @Override
    @Mapping(target = "stockID", source = "stockID")
    StockOHLCV toDomain(StockOHLCVEntity stockOHLCVEntity);
}