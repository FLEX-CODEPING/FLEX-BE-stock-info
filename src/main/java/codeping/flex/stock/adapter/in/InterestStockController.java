package codeping.flex.stock.adapter.in;

import codeping.flex.stock.application.port.in.InterestStockUsecase;
import codeping.flex.stock.adapter.in.dto.GetInterestStockInfoDto;
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
    @Operation(summary = "관심 종목 등록", description = "관심 종목을 등록합니다. 요청 성공 시에 인코딩된 pk를 반환합니다.")
    @ApiErrorCodes(stockErrors = {DUPLICATE_INTEREST_STOCK, STOCK_NOT_FOUND})
    public ApplicationResponse<String> addInterestStock(@Parameter(hidden = true) @Passport PassportInfo passportInfo,
                                                        @RequestParam("stockcode") String stockcode) {
        return ApplicationResponse.onSuccess(interestStockUsecase.addInterest(stockcode, passportInfo.userId()));
    }

    @DeleteMapping("/{interestStockId}")
    @Operation(summary = "관심 종목 삭제", description = "관심 종목을 삭제합니다.")
    @ApiErrorCodes(stockErrors = {INTEREST_STOCK_BAD_REQUEST})
    public ApplicationResponse<String> removeInterestStock(@Parameter(hidden = true) @Passport PassportInfo passportInfo,
                                                           @PathVariable("interestStockId") String interestStockId) {
        Long decodedId = interestStockUsecase.getDecodedId(interestStockId);
        interestStockUsecase.removeInterest(decodedId, passportInfo.userId());
        return ApplicationResponse.onSuccess("관심 종목 삭제가 성공하였습니다.");
    }

    @GetMapping("/{stockcode}")
    @Operation(summary = "관심 여부 조회", description = "특정 주식에 대해 관심 여부를 조회합니다. 관심 종목일 시에 인코딩된 pk를, 아닐 시에는 null을 반환합니다.")
    public ApplicationResponse<String> getInterestStock(@Parameter(hidden = true) @Passport PassportInfo passportInfo,
                                                        @PathVariable("stockcode") String stockcode) {
        return ApplicationResponse.onSuccess(interestStockUsecase.getIsInterest(stockcode, passportInfo.userId()));
    }

    @GetMapping()
    @Operation(summary = "관심 종목 조회", description = "관심 종목 목록을 조회합니다.")
    @ApiErrorCodes(stockErrors = {INVALID_PAGE_SIZE})
    public ApplicationResponse<SliceResponse<GetInterestStockInfoDto>> getInterestStocks(@Parameter(hidden = true) @Passport PassportInfo passportInfo,
                                                                                         @Parameter(example = "0", description = "0부터 시작합니다.") @RequestParam("page") int page,
                                                                                         @RequestParam("size") int size) {
        if(size < 0 || page < 0) {throw new ApplicationException(INVALID_PAGE_SIZE);}
        return ApplicationResponse.onSuccess(interestStockUsecase.getInterestStocks(passportInfo.userId(), page, size));
    }

}
