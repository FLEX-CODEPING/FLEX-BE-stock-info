package codeping.flex.stock.application.port.in.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class GetStockCorpInfoDto {

    @Schema(description = "기업명", example = "삼성전자")
    private String corpName;

    @Schema(description = "CEO 이름", example = "김기남")
    private String ceoName;

    @Schema(description = "기업 분류", example = "Y")
    private String corpClass;

    @Schema(description = "법인 등록 번호", example = "1234567890123")
    private String corpRegistNo;

    @Schema(description = "사업자 등록 번호", example = "123-45-67890")
    private String bsRegistNo;

    @Schema(description = "주소", example = "서울특별시 서초구 서초대로74길 11")
    private String address;

    @Schema(description = "홈페이지 URL", example = "https://www.samsung.com")
    private String homeUrl;

    @Schema(description = "설립일", example = "1969-01-13")
    private LocalDate establishmentDate;

    @Schema(description = "회계 연도 종료 월", example = "12")
    private String accountingMonth;

    @Schema(description = "산업명", example = "반도체 제조업")
    private String industryName;
}
