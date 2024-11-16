package codeping.flex.stock.adapter.out.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockOHLCVRepository extends JpaRepository<StockOHLCVEntity, StockIDEntity> {
}
