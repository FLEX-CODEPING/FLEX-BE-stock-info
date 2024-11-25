package codeping.flex.stock.adapter.out.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "corp_info")
public class CorpInfoEntity {
    @Id
    @Size(max = 50)
    @Column(name = "stockcode", nullable = false, length = 50)
    private String stockcode;

    @Column(name = "corp_number", length = 50)
    private String corpNumber;

    @Column(name = "corp_name")
    private String corpName;

    @Column(name = "stock_name", length = 100)
    private String stockName;

    @Column(name = "ceo_name")
    private String ceoName;

    @Column(name = "corp_class", length = 10)
    private String corpClass;

    @Column(name = "corp_regist_no", length = 50)
    private String corpRegistNo;

    @Column(name = "bs_regist_no", length = 50)
    private String bsRegistNo;

    @Column(name = "address")
    private String address;

    @Column(name = "home_url")
    private String homeUrl;

    @Column(name = "industry_code", length = 50)
    private String industryCode;

    @Column(name = "establishment_date")
    private LocalDate establishmentDate;

    @Column(name = "accounting_month", length = 10)
    private String accountingMonth;

    @Column(name = "industry_name", length = 50)
    private String industryName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_id", referencedColumnName = "stockcode", insertable = false, updatable = false)
    private StockEntity stock;
}