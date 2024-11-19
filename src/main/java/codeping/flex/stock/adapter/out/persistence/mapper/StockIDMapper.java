package codeping.flex.stock.adapter.out.persistence.mapper;

import codeping.flex.stock.adapter.out.persistence.entity.pk.StockIDEntity;
import codeping.flex.stock.domain.StockID;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StockIDMapper {
    StockIDMapper INSTANCE = Mappers.getMapper(StockIDMapper.class);

    StockID toDomain(StockIDEntity entity);
    StockIDEntity toEntity(StockID domain);
}
