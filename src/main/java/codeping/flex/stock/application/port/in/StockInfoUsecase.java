package codeping.flex.stock.application.port.in;

import codeping.flex.stock.application.port.in.dto.GetStockPreMarketInfoDto;
import codeping.flex.stock.application.port.in.dto.GetStockPreOpenSummaryInfoDto;
import codeping.flex.stock.application.port.in.dto.GetStockSummaryInfoDto;

import java.time.LocalDate;

public interface StockInfoUsecase {
    GetStockSummaryInfoDto getStockSummaryInfo(String stockcode);
    GetStockPreOpenSummaryInfoDto getStockPreOpenSummaryInfo(String stockcode, LocalDate date);
    GetStockPreMarketInfoDto getStockPreMarketInfo(String stockcode, LocalDate date);
}
