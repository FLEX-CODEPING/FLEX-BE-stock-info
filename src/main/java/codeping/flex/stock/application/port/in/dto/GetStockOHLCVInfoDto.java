package codeping.flex.stock.application.port.in.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class GetStockOHLCVInfoDto {
    private String stockcode;
    private LocalDate date;
    private Float openPrice;
    private Float highPrice;
    private Float lowPrice;
    private Float closePrice;
    private Long volume;
    private Float changeRate;
}
