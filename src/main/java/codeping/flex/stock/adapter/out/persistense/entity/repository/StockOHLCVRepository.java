package codeping.flex.stock.adapter.out.persistense.entity.repository;

import codeping.flex.stock.adapter.out.persistense.entity.pk.StockIDEntity;
import codeping.flex.stock.adapter.out.persistense.entity.StockOHLCVEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockOHLCVRepository extends JpaRepository<StockOHLCVEntity, StockIDEntity> {
}
