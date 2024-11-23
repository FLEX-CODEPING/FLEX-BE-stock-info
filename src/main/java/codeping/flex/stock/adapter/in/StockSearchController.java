package codeping.flex.stock.adapter.in;

import codeping.flex.stock.application.StockSearchService;
import codeping.flex.stock.application.port.in.dto.GetStockAutoCompleteDto;
import codeping.flex.stock.global.annotation.architecture.WebAdapter;
import codeping.flex.stock.global.common.response.ApplicationResponse;
import codeping.flex.stock.infrastructure.elasticsearch.document.StockDocument;
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
    public ApplicationResponse<List<GetStockAutoCompleteDto>> getStocksByKeyword(@RequestParam("keyword") String keyword,
                                                                                 @RequestParam("size") int size) throws IOException {
        return ApplicationResponse.onSuccess(stockSearchService.autoCompleteCorpName(keyword, size));
    }

    @GetMapping("/autocomplete/stockCode")
    public ApplicationResponse<List<GetStockAutoCompleteDto>> getStocksByKeywords(@RequestParam("keyword") String keyword,
                                                                                  @RequestParam("size") int size) throws IOException {
        return ApplicationResponse.onSuccess(stockSearchService.autoCompleteStockcode(keyword, size));
    }
}
