package codeping.flex.stock.application.mapper;

import codeping.flex.stock.application.port.in.dto.GetStockImageDto;
import codeping.flex.stock.domain.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GetStockImageDtoMapper {

    @Mapping(target = "stockcode", source = "stock.stockcode")
    @Mapping(target = "symbolImageUrl", source = "stock.imageUrl")
    GetStockImageDto toGetStockImageDto(Stock stock);
}
