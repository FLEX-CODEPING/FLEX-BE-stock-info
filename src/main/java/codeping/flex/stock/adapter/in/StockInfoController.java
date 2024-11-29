package codeping.flex.stock.adapter.in;

import codeping.flex.stock.adapter.in.dto.StockFundamentalInfoDto;
import codeping.flex.stock.adapter.in.dto.StockPreMarketInfoDto;
import codeping.flex.stock.adapter.in.dto.StockSummaryInfoDto;
import codeping.flex.stock.application.port.in.StockInfoUsecase;
import codeping.flex.stock.adapter.in.dto.StockPreOpenSummaryInfoDto;
import codeping.flex.stock.domain.execption.StockErrorCode;
import codeping.flex.stock.global.annotation.architecture.WebAdapter;
import codeping.flex.stock.global.annotation.passport.Passport;
import codeping.flex.stock.global.annotation.passport.PassportInfo;
import codeping.flex.stock.global.annotation.swagger.ApiErrorCodes;
import codeping.flex.stock.global.common.response.ApplicationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
public class StockInfoController {
    private final StockInfoUsecase stockInfoUsecase;

    @GetMapping("/{stockcode}")
    @Operation(summary = "주식 종목 정보 조회", description = "회사 이름, 코드, 이미지, 기업 정보를 반환합니다. 기업 정보는 데이터가 없을 시에 null을 반환합니다.")
    @ApiErrorCodes(stockErrors = {StockErrorCode.STOCK_NOT_FOUND})
    public ApplicationResponse<StockSummaryInfoDto> getStockSummaryInfo(@Parameter(hidden = true) @Passport PassportInfo passportInfo,
                                                                        @PathVariable("stockcode") String stockcode) {
        return ApplicationResponse.onSuccess(stockInfoUsecase.getStockSummaryInfo(stockcode));
    }

    @GetMapping("/{stockcode}/preOpen")
    @Operation(summary = "장 외 시간 주식 종목 정보 조회", description = "장 외 시간의 회사 이름, 코드, 이미지, 기업 정보 등을 반환합니다. 기업 정보는 데이터가 없을 시에 null을 반환합니다.")
    @ApiErrorCodes(stockErrors = {StockErrorCode.STOCK_NOT_FOUND})
    public ApplicationResponse<StockPreOpenSummaryInfoDto> getStockPreOpenSummaryInfo(@Parameter(hidden = true) @Passport PassportInfo passportInfo,
                                                                                      @PathVariable("stockcode") String stockcode,
                                                                                      @Parameter(description = "yyyy-MM-dd") @RequestParam("date")
                                                                                         @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return ApplicationResponse.onSuccess(stockInfoUsecase.getStockPreOpenSummaryInfo(stockcode, date));
    }

    @GetMapping("/market/preOpen")
    @Operation(summary = "장외 시간 주식 ohlcv & 시가총액 조회", description = "장외 시간 전일 주식 시가, 고가, 저가, 종가, 거래량, 시가 총액 정보")
    @ApiErrorCodes(stockErrors = {StockErrorCode.STOCK_OHLCV_NOT_FOUND})
    public ApplicationResponse<StockPreMarketInfoDto> getStockPreMarketInfo(@Parameter(hidden = true) @Passport PassportInfo passportInfo,
                                                                            @RequestParam("stockcode") String stockcode,
                                                                            @Parameter(description = "yyyy-MM-dd") @RequestParam("date")
                                                                               @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return ApplicationResponse.onSuccess(stockInfoUsecase.getStockPreMarketInfo(stockcode, date));
    }

    @GetMapping("/fundamental-data")
    @Operation(summary = "주식 재무제표 정보", description = "전일의 재무제표 정보를 조회합니다.")
    @ApiErrorCodes(stockErrors = {StockErrorCode.STOCK_OHLCV_NOT_FOUND})
    public ApplicationResponse<StockFundamentalInfoDto> getStockFundamentalInfo(@Parameter(hidden = true) @Passport PassportInfo passportInfo,
                                                                                @RequestParam("stockcode") String stockcode,
                                                                                @Parameter(description = "yyyy-MM-dd") @RequestParam("date")
                                                                               @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return ApplicationResponse.onSuccess(stockInfoUsecase.getStockFundamentalInfo(stockcode, date));
    }
}
