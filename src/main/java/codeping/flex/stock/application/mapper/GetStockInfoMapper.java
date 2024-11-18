package codeping.flex.stock.application.mapper;

import codeping.flex.stock.application.port.in.dto.GetStockPreMarketInfoDto;
import codeping.flex.stock.application.port.in.dto.GetStockSummaryInfoDto;
import codeping.flex.stock.domain.Stock;
import codeping.flex.stock.domain.StockImage;
import codeping.flex.stock.domain.StockMarketCap;
import codeping.flex.stock.domain.StockOHLCV;

public class GetStockInfoMapper {
    private GetStockInfoMapper() {
        throw new IllegalStateException("Util Class");
    }

    public static GetStockSummaryInfoDto toGetStockInfoDto(Stock stock, StockImage stockImage) {
        return GetStockSummaryInfoDto.builder()
                .stockcode(stock.getStockcode())
                .corpName(stock.getCorpName())
                .symbolImageUrl(stockImage == null ? null : stockImage.getImageUrl())
                .isInterested(null)
                .build();
    }

    public static GetStockPreMarketInfoDto toGetStockPreMarketInfoDto(StockOHLCV stockOHLCV, StockMarketCap stockMarketCap) {
        return GetStockPreMarketInfoDto.builder()
                .ohlcvInfo(toStockOHLCVInfoDto(stockOHLCV))
                .marketCapInfo(toStockMarketCapInfoDto(stockMarketCap))
                .build();
    }

    public static GetStockPreMarketInfoDto.StockOHLCVInfoDto toStockOHLCVInfoDto(StockOHLCV stockOHLCV) {
        return GetStockPreMarketInfoDto.StockOHLCVInfoDto.builder()
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

    public static GetStockPreMarketInfoDto.StockMarketCapInfoDto toStockMarketCapInfoDto(StockMarketCap stockMarketCap) {
        return GetStockPreMarketInfoDto.StockMarketCapInfoDto.builder()
                .stockcode(stockMarketCap.getStockID().getStockcode())
                .date(stockMarketCap.getStockID().getDate())
                .marketCap(stockMarketCap.getMarketCap())
                .volume(stockMarketCap.getVolume())
                .tradingVolume(stockMarketCap.getTradingValue())
                .listedShares(stockMarketCap.getListedShares())
                .build();
    }
}
