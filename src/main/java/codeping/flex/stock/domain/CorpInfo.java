package codeping.flex.stock.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Builder
public final class CorpInfo {
    private String stockcode;
    private String corpNumber;
    private String corpName;
    private String stockName;
    private String ceoName;
    private String corpClass;
    private String corpRegistNo;
    private String bsRegistNo;
    private String address;
    private String homeUrl;
    private String industryCode;
    private LocalDate establishmentDate;
    private String accountingMonth;
    private String industryName;
}