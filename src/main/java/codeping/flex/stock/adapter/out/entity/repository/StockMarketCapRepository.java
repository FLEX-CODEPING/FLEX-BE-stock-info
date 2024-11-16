package codeping.flex.stock.adapter.out.entity.repository;

import codeping.flex.stock.adapter.out.entity.StockIDEntity;
import codeping.flex.stock.adapter.out.entity.StockMarketCapEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockMarketCapRepository extends JpaRepository<StockMarketCapEntity, StockIDEntity> {
}
