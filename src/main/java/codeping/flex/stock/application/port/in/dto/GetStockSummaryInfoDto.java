package codeping.flex.stock.application.port.in.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetStockSummaryInfoDto {
    private String stockcode;
    private String corpName;
    private String symbolImageUrl;
    private Boolean isInterested;
}
