package codeping.flex.stock.application.mapper;

import codeping.flex.stock.application.port.in.dto.GetStockPreMarketInfoDto;
import codeping.flex.stock.application.port.in.dto.GetStockPreOpenSummaryInfoDto;
import codeping.flex.stock.application.port.in.dto.GetStockSummaryInfoDto;
import codeping.flex.stock.domain.Stock;
import codeping.flex.stock.domain.StockImage;
import codeping.flex.stock.domain.StockMarketCap;
import codeping.flex.stock.domain.StockOHLCV;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface GetStockInfoResponseMapper {

    @Mapping(target = "stockcode", source = "stock.stockcode")
    @Mapping(target = "corpName", source = "stock.corpName")
    @Mapping(target = "symbolImageUrl", source = "stockImage", qualifiedByName = "toSymbolImageUrl")
    GetStockSummaryInfoDto toGetStockSummaryInfoDto(Stock stock, StockImage stockImage);

    @Mapping(target = "stockcode", source = "stock.stockcode")
    @Mapping(target = "corpName", source = "stock.corpName")
    @Mapping(target = "symbolImageUrl", source = "stockImage", qualifiedByName = "toSymbolImageUrl")
    @Mapping(target = "closePrice", source = "stockOHLCV.closePrice")
    @Mapping(target = "volume", source = "stockOHLCV.volume")
    @Mapping(target = "changeRate", source = "stockOHLCV.changeRate")
    GetStockPreOpenSummaryInfoDto toGetStockSummaryPreMarketInfoDto(Stock stock, StockImage stockImage, StockOHLCV stockOHLCV);


    @Mapping(target = "ohlcvInfo", source = "stockOHLCV")
    @Mapping(target = "marketCapInfo", source = "stockMarketCap")
    GetStockPreMarketInfoDto toGetStockPreMarketInfoDto(StockOHLCV stockOHLCV, StockMarketCap stockMarketCap);

    @Mapping(target = "stockcode", source = "stockID.stockcode")
    @Mapping(target = "date", source = "stockID.date")
    GetStockPreMarketInfoDto.StockOHLCVInfoDto toStockOHLCVInfoDto(StockOHLCV stockOHLCV);

    @Mapping(target = "stockcode", source = "stockID.stockcode")
    @Mapping(target = "date", source = "stockID.date")
    @Mapping(target = "tradingVolume", source = "tradingValue")
    GetStockPreMarketInfoDto.StockMarketCapInfoDto toStockMarketCapInfoDto(StockMarketCap stockMarketCap);

    @Named("toSymbolImageUrl")
    default String toSymbolImageUrl(StockImage stockImage) {
        return stockImage == null ? null : stockImage.getImageUrl();
    }
}
