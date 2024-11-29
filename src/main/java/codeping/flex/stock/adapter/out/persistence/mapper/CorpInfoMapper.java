package codeping.flex.stock.adapter.out.persistence.mapper;

import codeping.flex.stock.adapter.out.persistence.entity.stockData.CorpInfoEntity;
import codeping.flex.stock.adapter.out.persistence.mapper.common.ReadOnlyEntityMapper;
import codeping.flex.stock.domain.stockData.CorpInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {StockMapper.class})
public interface CorpInfoMapper extends ReadOnlyEntityMapper<CorpInfoEntity, CorpInfo> {
    CorpInfoMapper INSTANCE = Mappers.getMapper(CorpInfoMapper.class);
}
