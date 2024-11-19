package codeping.flex.stock.adapter.out.persistence.mapper;

import codeping.flex.stock.adapter.out.persistence.entity.InterestStockEntity;
import codeping.flex.stock.domain.InterestStock;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InterestStockMapper {

    InterestStockMapper INSTANCE = Mappers.getMapper(InterestStockMapper.class);

    InterestStockEntity toEntity(InterestStock interestStock);
    InterestStock toDomain(InterestStockEntity entity);
}