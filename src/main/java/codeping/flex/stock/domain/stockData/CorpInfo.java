package codeping.flex.stock.domain.stockData;

import java.time.LocalDate;

public record CorpInfo(
        String stockcode,
        String corpNumber,
        String corpName,
        String stockName,
        String ceoName,
        String corpClass,
        String corpRegistNo,
        String bsRegistNo,
        String address,
        String homeUrl,
        String industryCode,
        LocalDate establishmentDate,
        String accountingMonth,
        String industryName,
        Stock stock
) {}