package codeping.flex.stock.adapter.in;

import codeping.flex.stock.application.StockSearchService;
import codeping.flex.stock.application.port.in.dto.GetStockAutoCompleteDto;
import codeping.flex.stock.global.annotation.architecture.WebAdapter;
import codeping.flex.stock.global.common.response.ApplicationResponse;
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
    private final StockSearchService stockSearchService;

    @GetMapping("/autocomplete/corpName")
    @Operation(summary = "기업명 자동 완성 검색", description = "기업명 자동 완성 검색결과를 조회합니다. 접두어를 기준으로 검색한 결과를 반환합니다.")
    public ApplicationResponse<List<GetStockAutoCompleteDto>> getStocksByKeyword(@Parameter(example = "삼성") @RequestParam("keyword") String keyword,
                                                                                 @RequestParam("size") int size) throws IOException {
        return ApplicationResponse.onSuccess(stockSearchService.autoCompleteCorpName(keyword, size));
    }

    @GetMapping("/autocomplete/stockCode")
    @Operation(summary = "기업명 자동 완성 검색", description = "종목 코드 자동 완성 검색결과를 조회합니다. 접두어를 기준으로 검색한 결과를 반환합니다.")
    public ApplicationResponse<List<GetStockAutoCompleteDto>> getStocksByKeywords(@Parameter(example = "0000") @RequestParam("keyword") String keyword,
                                                                                  @RequestParam("size") int size) throws IOException {
        return ApplicationResponse.onSuccess(stockSearchService.autoCompleteStockcode(keyword, size));
    }
}
