package codeping.flex.stock.adapter.out.persistense.entity.repository;

import codeping.flex.stock.adapter.out.persistense.entity.pk.StockIDEntity;
import codeping.flex.stock.adapter.out.persistense.entity.StockMarketCapEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockMarketCapRepository extends JpaRepository<StockMarketCapEntity, StockIDEntity> {
}
