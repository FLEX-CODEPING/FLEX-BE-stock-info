package codeping.flex.stock.adapter.out.persistence.mapper;

import codeping.flex.stock.adapter.out.persistence.entity.stockData.StockEntity;
import codeping.flex.stock.adapter.out.persistence.mapper.common.ReadOnlyEntityMapper;
import codeping.flex.stock.domain.stockData.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StockMapper extends ReadOnlyEntityMapper<StockEntity, Stock> {
    StockMapper INSTANCE = Mappers.getMapper(StockMapper.class);
}
