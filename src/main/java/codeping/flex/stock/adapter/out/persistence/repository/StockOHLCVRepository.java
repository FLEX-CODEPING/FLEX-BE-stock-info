package codeping.flex.stock.adapter.out.persistence.repository;

import codeping.flex.stock.adapter.out.persistence.entity.stockData.pk.StockIDEntity;
import codeping.flex.stock.adapter.out.persistence.entity.stockData.StockOHLCVEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockOHLCVRepository extends JpaRepository<StockOHLCVEntity, StockIDEntity> {
}
