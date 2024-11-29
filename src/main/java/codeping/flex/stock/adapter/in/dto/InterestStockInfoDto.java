package codeping.flex.stock.adapter.in.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record InterestStockInfoDto(
        String interestStockId,

        @Schema(description = "종목 코드") String stockcode,

        @Schema(description = "종목명") String stockName,

        @Schema(description = "로고 url") String symbolImageUrl
) {}
