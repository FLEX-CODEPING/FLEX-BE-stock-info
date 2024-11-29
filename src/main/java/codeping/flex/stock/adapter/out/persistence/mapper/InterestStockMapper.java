package codeping.flex.stock.adapter.out.persistence.mapper;

import codeping.flex.stock.adapter.out.persistence.entity.interest.InterestStockEntity;
import codeping.flex.stock.adapter.out.persistence.mapper.common.EntityMapper;
import codeping.flex.stock.domain.interest.InterestStock;
import codeping.flex.stock.domain.stockData.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InterestStockMapper extends EntityMapper<InterestStockEntity, InterestStock> {

    InterestStockMapper INSTANCE = Mappers.getMapper(InterestStockMapper.class);

    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "stockcode", source = "stock.stockcode")
    @Mapping(target = "stockName", source = "stock.stockName")
    InterestStock toDomain(Stock stock, Long userId);
}