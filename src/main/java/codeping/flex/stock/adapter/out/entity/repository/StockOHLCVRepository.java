package codeping.flex.stock.adapter.out.entity.repository;

import codeping.flex.stock.adapter.out.entity.pk.StockIDEntity;
import codeping.flex.stock.adapter.out.entity.StockOHLCVEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockOHLCVRepository extends JpaRepository<StockOHLCVEntity, StockIDEntity> {
}
