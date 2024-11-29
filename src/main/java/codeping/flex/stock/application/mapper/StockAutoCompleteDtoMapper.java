package codeping.flex.stock.application.mapper;

import codeping.flex.stock.adapter.in.dto.StockAutoCompleteDto;
import codeping.flex.stock.domain.stockData.StockDocumentDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StockAutoCompleteDtoMapper {

    @Mapping(target = "stockcode", source = "stockDocumentDomain.stockcode")
    @Mapping(target = "stockName", source = "stockDocumentDomain.stockName")
    @Mapping(target = "market", source = "stockDocumentDomain.market")
    StockAutoCompleteDto toDto(StockDocumentDomain stockDocumentDomain);
}
