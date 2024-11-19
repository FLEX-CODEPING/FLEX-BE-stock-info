package codeping.flex.stock.adapter.out.persistence.mapper;

import codeping.flex.stock.adapter.out.persistence.entity.StockImageEntity;
import codeping.flex.stock.domain.StockImage;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StockImageMapper {
    StockImageMapper INSTANCE = Mappers.getMapper(StockImageMapper.class);

    StockImage toDomain(StockImageEntity stockImageEntity);
}
