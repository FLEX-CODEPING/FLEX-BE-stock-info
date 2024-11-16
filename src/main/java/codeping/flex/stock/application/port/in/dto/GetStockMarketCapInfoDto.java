package codeping.flex.stock.application.port.in.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class GetStockMarketCapInfoDto {
    @Schema(description = "종목 코드")
    private String stockcode;
    @Schema(description = "기준일")
    private LocalDate date;
    @Schema(description = "시가 총액")
    private Long marketCap;
    @Schema(description = "총 거래량")
    private Long volume;
    @Schema(description = "당일 거래량")
    private Long tradingVolume;
    @Schema(description = "상장 주ㄱ수")
    private Long listedShares;
}