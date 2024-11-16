package codeping.flex.stock.adapter.in;

import codeping.flex.stock.application.port.in.StockInfoUsecase;
import codeping.flex.stock.application.port.in.dto.GetStockMarketCapInfoDto;
import codeping.flex.stock.application.port.in.dto.GetStockOHLCVInfoDto;
import codeping.flex.stock.application.port.in.dto.GetStockSummaryInfoDto;
import codeping.flex.stock.global.StockErrorCode;
import codeping.flex.stock.global.annotation.ApiErrorCodes;
import codeping.flex.stock.global.common.response.ApplicationResponse;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "주식 정보를 조회합니다.", description = "회사 이름, 코드, 이미지, 관심 종목 여부 등을 반환합니다. 전일 변동률은 장전 시간 주식 ohlcv 조회에서 사용해주세요.")
    @ApiErrorCodes(stockErrors = {StockErrorCode.STOCK_NOT_FOUND})
    public ApplicationResponse<GetStockSummaryInfoDto> getStockSummaryInfo(@PathVariable String stockcode) {
        return ApplicationResponse.onSuccess(stockUsecase.getStockInfo(stockcode));
    }

    @GetMapping("/{stockcode}/ohlcv/preOpen")
    @Operation(summary = "장전 시간 주식 ohlcv 조회", description = "장전 시간(오전 12~9시) 전일 주식 시가, 고가, 저가, 종가, 거래량,")
    @ApiErrorCodes(stockErrors = {StockErrorCode.STOCK_OHLCV_NOT_FOUND})
    public ApplicationResponse<GetStockOHLCVInfoDto> getStockOHLCVInfo(@PathVariable String stockcode) {
        return ApplicationResponse.onSuccess(stockUsecase.getStockOHLCVInfo(stockcode));
    }

    @GetMapping("/{stockcode}/marketCap/preOpen")
    @Operation(summary = "장전 시간 시가총액 조회", description = "장전 시간장 외 시간(오전 12~9시) 시가 총액에 대한 정보를 조회합니다.")
    @ApiErrorCodes(stockErrors = {StockErrorCode.STOCK_MARKET_CAP_NOT_FOUND})
    public ApplicationResponse<GetStockMarketCapInfoDto> getStockMarketCapInfo(@PathVariable String stockcode) {
        return ApplicationResponse.onSuccess(stockUsecase.getStockMarketCapInfo(stockcode));
    }
}
