package codeping.flex.stock.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Builder
public final class StockID {
    String stockcode;
    LocalDate date;
}