package codeping.flex.stock.adapter.in;

import codeping.flex.stock.application.port.in.InterestStockUsecase;
import codeping.flex.stock.application.port.in.dto.GetInterestStockInfoDto;
import codeping.flex.stock.domain.execption.StockErrorCode;
import codeping.flex.stock.global.annotation.architecture.WebAdapter;
import codeping.flex.stock.global.annotation.passport.Passport;
import codeping.flex.stock.global.annotation.passport.PassportInfo;
import codeping.flex.stock.global.annotation.swagger.ApiErrorCodes;
import codeping.flex.stock.global.common.exception.ApplicationException;
import codeping.flex.stock.global.common.response.ApplicationResponse;
import codeping.flex.stock.global.common.response.SliceResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static codeping.flex.stock.domain.execption.StockErrorCode.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/interestStocks")
@Tag(name = "Interest Stock Controller")
@WebAdapter
public class InterestStockController {
    private final InterestStockUsecase interestStockUsecase;

    @PostMapping()
    @Operation(summary = "관심 종목 등록", description = "관심 종목을 등록합니다.")
    @ApiErrorCodes(stockErrors = {DUPLICATE_INTEREST_STOCK, STOCK_NOT_FOUND})
    public ApplicationResponse<String> addInterestStock(@Parameter(hidden = true) @Passport PassportInfo passportInfo,
                                                        @RequestParam String stockcode) {
        interestStockUsecase.addInterest(stockcode, passportInfo.userId());
        return ApplicationResponse.onSuccess("관심 종목 등록이 성공하였습니다.");
    }

    @DeleteMapping("/{interestStockId}")
    @Operation(summary = "관심 종목 삭제", description = "관심 종목을 삭제합니다.")
    @ApiErrorCodes(stockErrors = {INTEREST_STOCK_BAD_REQUEST})
    public ApplicationResponse<String> removeInterestStock(@Parameter(hidden = true) @Passport PassportInfo passportInfo,
                                                           @PathVariable Long interestStockId) {
        interestStockUsecase.removeInterest(interestStockId, passportInfo.userId());
        return ApplicationResponse.onSuccess("관심 종목 삭제가 성공하였습니다.");
    }

    @GetMapping("/{stockcode}")
    @Operation(summary = "관심 여부 조회", description = "특정 주식에 대해 관심 여부를 조회합니다.")
    public ApplicationResponse<Boolean> getInterestStock(@Parameter(hidden = true) @Passport PassportInfo passportInfo,
                                                        @PathVariable String stockcode) {
        return ApplicationResponse.onSuccess(interestStockUsecase.getIsInterest(stockcode, passportInfo.userId()));
    }

    @GetMapping()
    @Operation(summary = "관심 종목 조회", description = "관심 종목 목록을 조회합니다.")
    @ApiErrorCodes(stockErrors = {INVALID_PAGE_SIZE})
    public ApplicationResponse<SliceResponse<GetInterestStockInfoDto>> getInterestStocks(@Parameter(hidden = true) @Passport PassportInfo passportInfo,
                                                                                         @Parameter(example = "0", description = "0부터 시작합니다.") @RequestParam int page,
                                                                                         @RequestParam int size) {
        if(size < 0 || page < 0) {throw new ApplicationException(INVALID_PAGE_SIZE);}
        return ApplicationResponse.onSuccess(interestStockUsecase.getInterestStocks(passportInfo.userId(), page, size));
    }

}
