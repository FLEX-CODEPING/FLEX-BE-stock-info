package codeping.flex.stock.application.port.in.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetStockAutoCompleteDto {
    @Schema(description = "종목 코드")
    private String stockcode;
    @Schema(description = "종목명")
    private String stockName;
    @Schema(description = "주식 시장")
    private String market;
}
