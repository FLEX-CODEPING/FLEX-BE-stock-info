package codeping.flex.stock.application.mapper;

import codeping.flex.stock.application.port.in.dto.GetStockAutoCompleteDto;
import codeping.flex.stock.domain.stockData.StockDocumentDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GetStockAutoCompleteDtoMapper {

    @Mapping(target = "stockcode", source = "stockDocumentDomain.stockcode")
    @Mapping(target = "stockName", source = "stockDocumentDomain.stockName")
    @Mapping(target = "market", source = "stockDocumentDomain.market")
    GetStockAutoCompleteDto toDto(StockDocumentDomain stockDocumentDomain);
}
