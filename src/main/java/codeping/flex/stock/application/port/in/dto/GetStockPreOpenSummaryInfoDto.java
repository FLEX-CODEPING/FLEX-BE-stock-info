package codeping.flex.stock.application.port.in.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class GetStockPreOpenSummaryInfoDto {
    @Schema(description = "종목 코드")
    private String stockcode;
    @Schema(description = "종목명")
    private String stockName;
    @Schema(description = "로고 url")
    private String symbolImageUrl;
    @Schema(description = "기업 정보")
    private GetStockCorpInfoDto corpInfo;
    @Schema(description = "기준일")
    private LocalDate date;
    @Schema(description = "종가")
    private Float closePrice;
    @Schema(description = "거래량")
    private Long volume;
    @Schema(description = "변화율")
    private Float changeRate;
}


