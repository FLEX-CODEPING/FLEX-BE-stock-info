package codeping.flex.stock.application.mapper;

import codeping.flex.stock.application.port.in.dto.GetStockAutoCompleteDto;
import codeping.flex.stock.domain.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GetStockAutoCompleteDtoMapper {

    @Mapping(target = "stockcode", source = "stock.stockcode")
    @Mapping(target = "stockName", source = "stock.stockName")
    @Mapping(target = "market", source = "stock.market")
    GetStockAutoCompleteDto toDto(Stock stock);
}
