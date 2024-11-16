package codeping.flex.stock.adapter.out.entity.repository;

import codeping.flex.stock.adapter.out.entity.StockIDEntity;
import codeping.flex.stock.adapter.out.entity.StockOHLCVEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockOHLCVRepository extends JpaRepository<StockOHLCVEntity, StockIDEntity> {
}
