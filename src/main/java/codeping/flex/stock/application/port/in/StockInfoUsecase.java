package codeping.flex.stock.application.port.in;

import codeping.flex.stock.application.port.in.dto.GetStockMarketCapInfoDto;
import codeping.flex.stock.application.port.in.dto.GetStockOHLCVInfoDto;
import codeping.flex.stock.application.port.in.dto.GetStockSummaryInfoDto;

public interface StockInfoUsecase {
    GetStockSummaryInfoDto getStockInfo(String stockcode);

    GetStockOHLCVInfoDto getStockOHLCVInfo(String stockcode);

    GetStockMarketCapInfoDto getStockMarketCapInfo(String stockcode);
}
