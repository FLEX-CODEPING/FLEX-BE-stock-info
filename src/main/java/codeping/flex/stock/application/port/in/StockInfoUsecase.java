package codeping.flex.stock.application.port.in;

import codeping.flex.stock.application.port.in.dto.GetStockPreMarketInfoDto;
import codeping.flex.stock.application.port.in.dto.GetStockSummaryInfoDto;

import java.time.LocalDate;

public interface StockInfoUsecase {
    GetStockSummaryInfoDto getStockSummaryInfo(String stockcode);

    GetStockPreMarketInfoDto getStockPreMarketInfo(String stockcode, LocalDate date);
}
