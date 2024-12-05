package codeping.flex.stock.application.mapper;

import codeping.flex.stock.application.port.in.dto.GetStockCorpInfoDto;
import codeping.flex.stock.application.port.in.dto.GetStockPreMarketInfoDto;
import codeping.flex.stock.application.port.in.dto.GetStockPreOpenSummaryInfoDto;
import codeping.flex.stock.application.port.in.dto.GetStockSummaryInfoDto;
import codeping.flex.stock.domain.*;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;

@Mapper(componentModel = "spring")
public interface GetStockInfoResponseMapper {

    /**
     * 장 중 시간대의 주식 기본 정보 dto mapper
     */
    @Mapping(target = "stockcode", source = "stock.stockcode")
    @Mapping(target = "stockName", source = "stock.stockName")
    @Mapping(target = "symbolImageUrl", source = "stock.imageUrl")
    GetStockSummaryInfoDto toGetStockSummaryInfoDto(Stock stock);

    /**
     * 장 외 시간대의 주식 기본 정보 dto mapper
     */
    @Mapping(target = "stockcode", source = "stock.stockcode")
    @Mapping(target = "stockName", source = "stock.stockName")
    @Mapping(target = "symbolImageUrl", source = "stock.imageUrl")
    @Mapping(target = "closePrice", source = "stockOHLCV.closePrice")
    @Mapping(target = "volume", source = "stockOHLCV.volume")
    @Mapping(target = "changeRate", source = "stockOHLCV.changeRate")
    GetStockPreOpenSummaryInfoDto toGetStockSummaryPreMarketInfoDto(StockOHLCV stockOHLCV, Stock stock, LocalDate date);

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

    GetStockCorpInfoDto toGetStockCorpInfoDto(CorpInfo corpInfo);
}
