package codeping.flex.stock.adapter.out.persistence.repository;

import codeping.flex.stock.adapter.out.persistence.entity.pk.StockIDEntity;
import codeping.flex.stock.adapter.out.persistence.entity.StockOHLCVEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockOHLCVRepository extends JpaRepository<StockOHLCVEntity, StockIDEntity> {
}
