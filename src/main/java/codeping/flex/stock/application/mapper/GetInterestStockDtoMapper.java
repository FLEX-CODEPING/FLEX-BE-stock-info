package codeping.flex.stock.application.mapper;

import codeping.flex.stock.application.port.in.dto.GetInterestStockInfoDto;
import codeping.flex.stock.domain.interest.InterestStock;
import codeping.flex.stock.domain.stockData.StockImage;
import codeping.flex.stock.global.utils.PkEncoderUtil;
import org.mapstruct.*;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface GetInterestStockDtoMapper {

    @Mappings({
            @Mapping(target = "interestStockId", source = "interestStock.id", qualifiedByName = "encryptId"),
            @Mapping(target = "stockcode", source = "interestStock.stockcode"),
            @Mapping(target = "stockName", source = "interestStock.stockName"),
            @Mapping(target = "symbolImageUrl", source = "stockImage", qualifiedByName = "toSymbolImageUrl")
    })
    GetInterestStockInfoDto toDto(
            InterestStock interestStock,
            StockImage stockImage,
            @Context PkEncoderUtil pkEncoderUtil);

    default List<GetInterestStockInfoDto> toDtoList(
            List<InterestStock> interestStocks,
            List<StockImage> stockImages,
            @Context PkEncoderUtil pkEncoderUtil) {

        Map<String, StockImage> stockImageMap = stockImages.stream()
                .collect(Collectors.toMap(
                        StockImage::getStockcode,
                        Function.identity(),
                        (existing, replacement) -> existing // 중복 키 처리
                ));

        return interestStocks.stream()
                .map(interestStock -> {
                    StockImage stockImage = stockImageMap.get(interestStock.getStockcode());
                    return toDto(interestStock, stockImage, pkEncoderUtil);
                })
                .collect(Collectors.toList());
    }

    @Named("toSymbolImageUrl")
    default String toSymbolImageUrl(StockImage stockImage) {
        return stockImage != null ? stockImage.getImageUrl() : null;
    }

    @Named("encryptId")
    default String encryptId(Long id, @Context PkEncoderUtil pkEncoderUtil) {
        return pkEncoderUtil.encryptValue(id);
    }
}

