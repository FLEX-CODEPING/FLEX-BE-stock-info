package codeping.flex.stock.adapter.out.persistence.entity.pk;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Embeddable
public class StockIDEntity {
    @Column
    private LocalDate date;

    @Column
    private String stockcode;

    @Builder
    public StockIDEntity(LocalDate date, String stockcode) {
        this.date = date;
        this.stockcode = stockcode;
    }
}