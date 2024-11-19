package codeping.flex.stock.adapter.out.persistence.mapper;

import codeping.flex.stock.adapter.out.persistence.entity.InterestStockEntity;
import codeping.flex.stock.domain.InterestStock;
import codeping.flex.stock.domain.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InterestStockMapper {

    InterestStockMapper INSTANCE = Mappers.getMapper(InterestStockMapper.class);

    InterestStockEntity toEntity(InterestStock interestStock);
    InterestStock toDomain(InterestStockEntity entity);

    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "stockcode", source = "stock.stockcode")
    @Mapping(target = "corpName", source = "stock.corpName")
    InterestStock toDomain(Stock stock, Long userId);
}