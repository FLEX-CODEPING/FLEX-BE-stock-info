package codeping.flex.stock.adapter.in.dto;


import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

public record StockCorpInfoDto(
        @Schema(description = "기업명", example = "삼성전자") String corpName,
        @Schema(description = "CEO 이름", example = "김기남") String ceoName,
        @Schema(description = "법인 등록 번호", example = "1234567890123") String corpRegistNo,
        @Schema(description = "사업자 등록 번호", example = "123-45-67890") String bsRegistNo,
        @Schema(description = "주소", example = "서울특별시 서초구 서초대로74길 11") String address,
        @Schema(description = "홈페이지 URL", example = "https://www.samsung.com") String homeUrl,
        @Schema(description = "설립일", example = "1969-01-13") LocalDate establishmentDate,
        @Schema(description = "회계 연도 종료 월", example = "12") String accountingMonth,
        @Schema(description = "산업명", example = "반도체 제조업") String industryName
) {}
