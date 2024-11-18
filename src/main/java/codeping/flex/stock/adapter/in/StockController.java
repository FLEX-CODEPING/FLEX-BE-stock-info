package codeping.flex.stock.adapter.in;

import codeping.flex.stock.application.port.in.StockInfoUsecase;
import codeping.flex.stock.application.port.in.dto.GetStockPreMarketInfoDto;
import codeping.flex.stock.application.port.in.dto.GetStockSummaryInfoDto;
import codeping.flex.stock.global.StockErrorCode;
import codeping.flex.stock.global.annotation.architecture.WebAdapter;
import codeping.flex.stock.global.annotation.swagger.ApiErrorCodes;
import codeping.flex.stock.global.common.response.ApplicationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stocks")
@Tag(name = "Stock Info Controller")
@WebAdapter
public class StockController {
    private final StockInfoUsecase stockUsecase;

    @GetMapping("/{stockcode}")
    @Operation(summary = "주식 정보를 조회합니다.", description = "회사 이름, 코드, 이미지, 관심 종목 여부 등을 반환합니다. 전일 변동률은 장전 시간 주식 ohlcv 조회에서 사용해주세요.")
    @ApiErrorCodes(stockErrors = {StockErrorCode.STOCK_NOT_FOUND})
    public ApplicationResponse<GetStockSummaryInfoDto> getStockSummaryInfo(@PathVariable String stockcode) {
        return ApplicationResponse.onSuccess(stockUsecase.getStockSummaryInfo(stockcode));
    }

    @GetMapping("/market/preOpen")
    @Operation(summary = "장전 시간 주식 ohlcv & 시가총액 조회", description = "장전 시간(오전 12~9시) 전일 주식 시가, 고가, 저가, 종가, 거래량,")
    @ApiErrorCodes(stockErrors = {StockErrorCode.STOCK_OHLCV_NOT_FOUND})
    public ApplicationResponse<GetStockPreMarketInfoDto> getStockMarketInfo(@RequestParam String stockcode, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return ApplicationResponse.onSuccess(stockUsecase.getStockPreMarketInfo(stockcode, date));
    }

}
