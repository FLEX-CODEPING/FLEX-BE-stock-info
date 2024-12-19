package codeping.flex.stock.adapter.in;

import codeping.flex.stock.application.port.in.StockImageUsecase;
import codeping.flex.stock.application.port.in.dto.GetStockImageDto;
import codeping.flex.stock.domain.execption.StockErrorCode;
import codeping.flex.stock.global.annotation.architecture.WebAdapter;
import codeping.flex.stock.global.annotation.swagger.ApiErrorCodes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stocks/image-url")
@Tag(name = "Stock Image Controller")
@WebAdapter
public class StockImageController {
    private final StockImageUsecase stockImageUsecase;


    @GetMapping("")
    @Operation(summary = "주식 이미지 조회", description = "주식 회사 이미지 정보를 반환합니다.", hidden = true)
    @ApiErrorCodes(stockErrors = {StockErrorCode.STOCK_NOT_FOUND})
    public Mono<List<GetStockImageDto>> getStockImages(@RequestParam(name = "stockcodes") List<String> stockcodes) {
        return Mono.fromCallable(() -> stockImageUsecase.getStockImageUrls(stockcodes))
                .onErrorResume(e -> Mono.just(List.of()));
        }
}
