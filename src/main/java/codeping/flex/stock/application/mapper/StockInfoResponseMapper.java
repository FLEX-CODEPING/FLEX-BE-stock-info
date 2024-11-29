package codeping.flex.stock.application.mapper;

import codeping.flex.stock.adapter.in.dto.StockCorpInfoDto;
import codeping.flex.stock.adapter.in.dto.StockPreMarketInfoDto;
import codeping.flex.stock.adapter.in.dto.StockPreOpenSummaryInfoDto;
import codeping.flex.stock.adapter.in.dto.StockSummaryInfoDto;

import codeping.flex.stock.domain.stockData.CorpInfo;
import codeping.flex.stock.domain.stockData.StockMarketCap;
import codeping.flex.stock.domain.stockData.StockOHLCV;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;

@Mapper(componentModel = "spring")
public interface StockInfoResponseMapper {

    /**
     * 장 중 시간대의 주식 기본 정보 dto mapper
     */
    @Mapping(target = "stockcode", source = "stockWithCorpInfo.stock.stockcode")
    @Mapping(target = "stockName", source = "stockWithCorpInfo.stock.stockName")
    @Mapping(target = "symbolImageUrl", source = "stockWithCorpInfo.stock.imageUrl")
    @Mapping(target = "market", expression = "java(stockWithCorpInfo.stock().getFormattedMarket())")
    @Mapping(target = "corpInfo", source = "stockWithCorpInfo")
    StockSummaryInfoDto toGetStockSummaryInfoDto(CorpInfo stockWithCorpInfo);

    /**
     * 장 외 시간대의 주식 기본 정보 dto mapper
     */
    @Mapping(target = "stockcode", source = "stockWithCorpInfo.stock.stockcode")
    @Mapping(target = "stockName", source = "stockWithCorpInfo.stock.stockName")
    @Mapping(target = "symbolImageUrl", source = "stockWithCorpInfo.stock.imageUrl")
    @Mapping(target = "market", expression = "java(stockWithCorpInfo.stock().getFormattedMarket())")
    @Mapping(target = "closePrice", source = "stockOHLCV.closePrice")
    @Mapping(target = "volume", source = "stockOHLCV.volume")
    @Mapping(target = "changeRate", source = "stockOHLCV.changeRate")
    @Mapping(target = "corpInfo", source = "stockWithCorpInfo")
    StockPreOpenSummaryInfoDto toGetStockSummaryPreMarketInfoDto(StockOHLCV stockOHLCV, CorpInfo stockWithCorpInfo, LocalDate date);

    @Mapping(target = "ohlcvInfo", source = "stockOHLCV")
    @Mapping(target = "marketCapInfo", source = "stockMarketCap")
    StockPreMarketInfoDto toGetStockPreMarketInfoDto(StockOHLCV stockOHLCV, StockMarketCap stockMarketCap);

    @Mapping(target = "stockcode", source = "stockID.stockcode")
    @Mapping(target = "date", source = "stockID.date")
    StockPreMarketInfoDto.StockOHLCVInfoDto toStockOHLCVInfoDto(StockOHLCV stockOHLCV);

    @Mapping(target = "stockcode", source = "stockID.stockcode")
    @Mapping(target = "date", source = "stockID.date")
    @Mapping(target = "tradingVolume", source = "tradingValue")
    StockPreMarketInfoDto.StockMarketCapInfoDto toStockMarketCapInfoDto(StockMarketCap stockMarketCap);

    StockCorpInfoDto toGetStockCorpInfoDto(CorpInfo corpInfo);
}
