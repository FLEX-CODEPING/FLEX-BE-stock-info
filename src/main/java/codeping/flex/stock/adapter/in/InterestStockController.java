package codeping.flex.stock.adapter.in;

import codeping.flex.stock.application.port.in.InterestStockUsecase;
import codeping.flex.stock.global.annotation.architecture.WebAdapter;
import codeping.flex.stock.global.annotation.passport.Passport;
import codeping.flex.stock.global.annotation.passport.PassportInfo;
import codeping.flex.stock.global.annotation.swagger.ApiErrorCodes;
import codeping.flex.stock.global.common.response.ApplicationResponse;
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
                                                @RequestParam String stockcode){
        interestStockUsecase.addInterest(stockcode, passportInfo.userId());
        return ApplicationResponse.onSuccess("관심 종목 등록이 성공하였습니다.");
    }

    @DeleteMapping("/{interestStockId}")
    @Operation(summary = "관심 종목 삭제", description = "관심 종목을 삭제합니다.")
    @ApiErrorCodes(stockErrors = {INTEREST_STOCK_BAD_REQUEST})
    public ApplicationResponse<String> removeInterestStock(@Parameter(hidden = true) @Passport PassportInfo passportInfo,
                                                        @PathVariable Long interestStockId){
        interestStockUsecase.removeInterest(interestStockId, passportInfo.userId());
        return ApplicationResponse.onSuccess("관심 종목 삭제가 성공하였습니다.");
    }
}
