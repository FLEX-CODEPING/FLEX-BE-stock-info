package codeping.flex.stock.application.mapper;

import codeping.flex.stock.application.port.in.dto.GetStockMarketCapInfoDto;
import codeping.flex.stock.application.port.in.dto.GetStockOHLCVInfoDto;
import codeping.flex.stock.application.port.in.dto.GetStockSummaryInfoDto;
import codeping.flex.stock.domain.Stock;
import codeping.flex.stock.domain.StockMarketCap;
import codeping.flex.stock.domain.StockOHLCV;

public class GetStockInfoMapper {
    private GetStockInfoMapper() {
        throw new IllegalStateException("Util Class");
    }

    public static GetStockSummaryInfoDto toGetStockInfoDto(Stock stock, String symbolImageUrl) {
        return GetStockSummaryInfoDto.builder()
                .stockcode(stock.getStockcode())
                .corpName(stock.getCorpName())
                .symbolImageUrl(symbolImageUrl)
                .isInterested(null)
                .build();
    }

    public static GetStockOHLCVInfoDto toGetStockOHLCVInfoDto(StockOHLCV stockOHLCV) {
        return GetStockOHLCVInfoDto.builder()
                .stockcode(stockOHLCV.getStockID().getStockcode())
                .date(stockOHLCV.getStockID().getDate())
                .openPrice(stockOHLCV.getOpenPrice())
                .highPrice(stockOHLCV.getHighPrice())
                .lowPrice(stockOHLCV.getLowPrice())
                .closePrice(stockOHLCV.getClosePrice())
                .volume(stockOHLCV.getVolume())
                .changeRate(stockOHLCV.getChangeRate())
                .build();
    }

    public static GetStockMarketCapInfoDto toGetStockMarketCapInfoDto(StockMarketCap stockMarketCap) {
        return GetStockMarketCapInfoDto.builder()
                .stockcode(stockMarketCap.getStockID().getStockcode())
                .date(stockMarketCap.getStockID().getDate())
                .marketCap(stockMarketCap.getMarketCap())
                .volume(stockMarketCap.getVolume())
                .tradingVolume(stockMarketCap.getTradingValue())
                .listedShares(stockMarketCap.getListedShares())
                .build();
    }
}
