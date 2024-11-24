package codeping.flex.stock.adapter.out.persistence.mapper;

import codeping.flex.stock.adapter.out.persistence.entity.StockImageEntity;
import codeping.flex.stock.adapter.out.persistence.mapper.common.ReadOnlyEntityMapper;
import codeping.flex.stock.domain.StockImage;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StockImageMapper extends ReadOnlyEntityMapper<StockImageEntity, StockImage> {
    StockImageMapper INSTANCE = Mappers.getMapper(StockImageMapper.class);
}
