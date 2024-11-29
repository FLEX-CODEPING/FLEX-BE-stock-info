package codeping.flex.stock.adapter.in.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

public record StockPreOpenSummaryInfoDto(
        @Schema(description = "종목 코드") String stockcode,
        @Schema(description = "종목명") String stockName,
        @Schema(description = "로고 url") String symbolImageUrl,
        @Schema(description = "시장 정보, KOSPI /KOSDAQ") String market,
        @Schema(description = "기업 정보") StockCorpInfoDto corpInfo,
        @Schema(description = "기준일") LocalDate date,
        @Schema(description = "종가") Float closePrice,
        @Schema(description = "거래량") Long volume,
        @Schema(description = "변화율") Float changeRate
) {}

