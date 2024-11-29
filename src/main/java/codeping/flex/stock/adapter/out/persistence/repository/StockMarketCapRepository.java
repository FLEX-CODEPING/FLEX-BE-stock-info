package codeping.flex.stock.adapter.out.persistence.repository;

import codeping.flex.stock.adapter.out.persistence.entity.stockData.pk.StockIDEntity;
import codeping.flex.stock.adapter.out.persistence.entity.stockData.StockMarketCapEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockMarketCapRepository extends JpaRepository<StockMarketCapEntity, StockIDEntity> {
}
