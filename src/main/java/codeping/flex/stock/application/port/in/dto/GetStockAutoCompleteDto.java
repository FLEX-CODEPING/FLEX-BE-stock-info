package codeping.flex.stock.application.port.in.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetStockAutoCompleteDto {
    private String stockcode;
    private String corpName;
    private String market;
}
