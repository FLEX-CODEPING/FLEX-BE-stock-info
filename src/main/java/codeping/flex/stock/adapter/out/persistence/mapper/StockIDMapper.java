package codeping.flex.stock.adapter.out.persistence.mapper;

import codeping.flex.stock.adapter.out.persistence.entity.pk.StockIDEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;

@Mapper(componentModel = "spring")
public interface StockIDMapper {
    StockIDMapper INSTANCE = Mappers.getMapper(StockIDMapper.class);

    @Mapping(target = "stockcode", source = "stockcode")
    @Mapping(target = "date", source = "date")
    StockIDEntity toEntity(String stockcode, LocalDate date);
}
