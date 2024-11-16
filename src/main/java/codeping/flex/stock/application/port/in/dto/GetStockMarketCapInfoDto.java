package codeping.flex.stock.application.port.in.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class GetStockMarketCapInfoDto {
    private String stockcode;
    private LocalDate date;
    private Long marketCap;
    private Long volume;
    private Long tradingVolume;
    private Long listedShares;
}