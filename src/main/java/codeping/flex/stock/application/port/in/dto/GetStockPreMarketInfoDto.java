package codeping.flex.stock.application.port.in.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class GetStockPreMarketInfoDto {

    private StockMarketCapInfoDto marketCapInfo;
    private StockOHLCVInfoDto ohlcvInfo;

    @Getter
    @Builder
    public static class StockMarketCapInfoDto {
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

    @Getter
    @Builder
    public static class StockOHLCVInfoDto {
        @Schema(description = "종목 코드")
        private String stockcode;
        @Schema(description = "기준일")
        private LocalDate date;
        @Schema(description = "시가")
        private Float openPrice;
        @Schema(description = "고가")
        private Float highPrice;
        @Schema(description = "저가")
        private Float lowPrice;
        @Schema(description = "종가")
        private Float closePrice;
        @Schema(description = "거래량")
        private Long volume;
        @Schema(description = "변화율")
        private Float changeRate;
    }
}
