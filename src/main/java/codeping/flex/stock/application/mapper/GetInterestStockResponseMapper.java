package codeping.flex.stock.application.mapper;

import codeping.flex.stock.application.port.in.dto.GetInterestStockInfoDto;
import codeping.flex.stock.domain.InterestStock;
import codeping.flex.stock.domain.StockImage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface GetInterestStockResponseMapper {

    @Mappings({
            @Mapping(target = "id", source = "interestStock.id"),
            @Mapping(target = "stockcode", source = "interestStock.stockcode"),
            @Mapping(target = "corpName", source = "interestStock.corpName"),
            @Mapping(target = "symbolImageUrl", source = "stockImage", qualifiedByName = "toSymbolImageUrl")
    })
    GetInterestStockInfoDto toDto(InterestStock interestStock, StockImage stockImage);

    default List<GetInterestStockInfoDto> toDtoList(
            List<InterestStock> interestStocks,
            List<StockImage> stockImages
    ) {
        Map<String, StockImage> stockImageMap = stockImages.stream()
                .collect(Collectors.toMap(
                        StockImage::getStockcode,
                        Function.identity(),
                        (existing, replacement) -> existing // 중복 키 처리
                ));

        return interestStocks.stream()
                .map(interestStock -> {
                    StockImage stockImage = stockImageMap.get(interestStock.getStockcode());
                    return toDto(interestStock, stockImage);
                })
                .collect(Collectors.toList());
    }



    @Named("toSymbolImageUrl")
    default String toSymbolImageUrl(StockImage stockImage) {
        return stockImage != null ? stockImage.getImageUrl() : null;
    }
}