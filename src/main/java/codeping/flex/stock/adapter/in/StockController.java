package codeping.flex.stock.adapter.in;

import codeping.flex.stock.application.port.in.StockInfoUsecase;
import codeping.flex.stock.application.port.in.dto.GetStockMarketCapInfoDto;
import codeping.flex.stock.application.port.in.dto.GetStockOHLCVInfoDto;
import codeping.flex.stock.application.port.in.dto.GetStockSummaryInfoDto;
import codeping.flex.stock.global.common.response.ApplicationResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stocks")
@Tag(name = "Stock Info Controller")
public class StockController {
    private final StockInfoUsecase stockUsecase;

    @GetMapping("/{stockcode}")
    public ApplicationResponse<GetStockSummaryInfoDto> getStockSummaryInfo(@PathVariable String stockcode) {
        return ApplicationResponse.onSuccess(stockUsecase.getStockInfo(stockcode));
    }

    @GetMapping("/{stockcode}/ohlcv")
    public ApplicationResponse<GetStockOHLCVInfoDto> getStockOHLCVInfo(@PathVariable String stockcode) {
        return ApplicationResponse.onSuccess(stockUsecase.getStockOHLCVInfo(stockcode));
    }

    @GetMapping("/{stockcode}/marketCap")
    public ApplicationResponse<GetStockMarketCapInfoDto> getStockMarketCapInfo(@PathVariable String stockcode) {
        return ApplicationResponse.onSuccess(stockUsecase.getStockMarketCapInfo(stockcode));
    }
}
