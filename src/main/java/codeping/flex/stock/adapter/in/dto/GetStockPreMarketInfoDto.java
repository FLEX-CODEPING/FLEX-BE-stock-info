package codeping.flex.stock.adapter.in.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

import java.time.LocalDate;

public record GetStockPreMarketInfoDto(
        StockMarketCapInfoDto marketCapInfo,
        StockOHLCVInfoDto ohlcvInfo
) {

    public record StockMarketCapInfoDto(
            @Schema(description = "종목 코드")
            String stockcode,
            @Schema(description = "기준일")
            LocalDate date,
            @Schema(description = "시가 총액")
            Long marketCap,
            @Schema(description = "총 거래량")
            Long volume,
            @Schema(description = "당일 거래량")
            Long tradingVolume,
            @Schema(description = "상장 주식수")
            Long listedShares
    ) {}

    public record StockOHLCVInfoDto(
            @Schema(description = "종목 코드")
            String stockcode,
            @Schema(description = "기준일")
            LocalDate date,
            @Schema(description = "시가")
            Float openPrice,
            @Schema(description = "고가")
            Float highPrice,
            @Schema(description = "저가")
            Float lowPrice,
            @Schema(description = "종가")
            Float closePrice,
            @Schema(description = "거래량")
            Long volume,
            @Schema(description = "변화율")
            Float changeRate
    ) {}
}
