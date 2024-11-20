package codeping.flex.stock.adapter.out.persistence.mapper;

import codeping.flex.stock.adapter.out.persistence.entity.StockMarketCapEntity;
import codeping.flex.stock.domain.StockMarketCap;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {StockIDMapper.class})
public interface StockMarketCapMapper {
    StockMarketCapMapper INSTANCE = Mappers.getMapper(StockMarketCapMapper.class);

    @Mapping(target = "stockID", source = "stockID")
    StockMarketCap toDomain(StockMarketCapEntity entity);
}