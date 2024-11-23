package codeping.flex.stock.adapter.out.persistence.mapper;

import codeping.flex.stock.domain.Stock;
import codeping.flex.stock.infrastructure.elasticsearch.document.StockDocument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StockDocumentMapper {
    StockDocumentMapper INSTANCE = Mappers.getMapper(StockDocumentMapper.class);

    Stock toDomain(StockDocument stockDocument);
}
