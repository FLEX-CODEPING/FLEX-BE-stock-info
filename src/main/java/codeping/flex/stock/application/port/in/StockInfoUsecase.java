package codeping.flex.stock.application.port.in;

import codeping.flex.stock.adapter.in.dto.StockFundamentalInfoDto;
import codeping.flex.stock.adapter.in.dto.StockPreMarketInfoDto;
import codeping.flex.stock.adapter.in.dto.StockPreOpenSummaryInfoDto;
import codeping.flex.stock.adapter.in.dto.StockSummaryInfoDto;

import java.time.LocalDate;

public interface StockInfoUsecase {
    StockSummaryInfoDto getStockSummaryInfo(String stockcode);
    StockPreOpenSummaryInfoDto getStockPreOpenSummaryInfo(String stockcode, LocalDate date);
    StockPreMarketInfoDto getStockPreMarketInfo(String stockcode, LocalDate date);
    StockFundamentalInfoDto getStockFundamentalInfo(String stockcode, LocalDate date);
}
