package codeping.flex.stock.adapter.out.persistence.repository;

import codeping.flex.stock.adapter.out.persistence.entity.pk.StockIDEntity;
import codeping.flex.stock.adapter.out.persistence.entity.StockMarketCapEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockMarketCapRepository extends JpaRepository<StockMarketCapEntity, StockIDEntity> {
}
