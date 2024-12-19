package codeping.flex.stock.adapter.in;

import codeping.flex.stock.application.StockSearchService;
import codeping.flex.stock.application.port.in.StockSearchUsecase;
import codeping.flex.stock.application.port.in.dto.GetStockAutoCompleteDto;
import codeping.flex.stock.global.annotation.architecture.WebAdapter;
import codeping.flex.stock.global.common.exception.ApplicationException;
import codeping.flex.stock.global.common.response.ApplicationResponse;
import codeping.flex.stock.global.common.response.code.CommonErrorCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stocks/search")
@Tag(name = "Stock Search Controller")
@WebAdapter
public class StockSearchController {
    private final StockSearchUsecase stockSearchUsecase;

    @GetMapping("/autoComplete/V1")
    @Operation(summary = "자동 완성 검색", description = "자동 완성 검색결과를 조회합니다. 접두어를 기준으로 검색하며, 문자열의 숫자/문자 여부에 따라 결과를 반환합니다.")
    public ApplicationResponse<List<GetStockAutoCompleteDto>> getAutoCompleteStocks(@Parameter(example = "삼성") @RequestParam("keyword") String keyword,
                                                                                    @RequestParam("size") int size) throws IOException {
        return ApplicationResponse.onSuccess(stockSearchUsecase.getAutoCompleteStocks(keyword, size));
    }

    @GetMapping("/autoComplete/V2")
    @Operation(summary = "자동 완성 검색", description = "자동 완성 검색결과를 조회합니다. 접두어를 기준으로 검색한 결과를 반환합니다.")
    public ApplicationResponse<List<GetStockAutoCompleteDto>> getStocksByKeyword(@Parameter(example = "stockName", description = "stockcode 또는 stockName 입력") @RequestParam("searchType") String searchType,
                                                                                 @Parameter(example = "삼성") @RequestParam("keyword") String keyword,
                                                                                 @RequestParam("size") int size) throws IOException {
        if(!searchType.equals("stockcode") && !searchType.equals("stockName")) {
            throw ApplicationException.from(CommonErrorCode.BAD_REQUEST);
        }
        return ApplicationResponse.onSuccess(stockSearchUsecase.getAutoCompleteStocks(keyword, size));
    }
}
