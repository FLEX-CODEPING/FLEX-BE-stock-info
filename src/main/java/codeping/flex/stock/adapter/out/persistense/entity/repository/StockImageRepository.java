package codeping.flex.stock.adapter.out.persistense.entity.repository;

import codeping.flex.stock.adapter.out.persistense.entity.StockImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockImageRepository extends JpaRepository<StockImageEntity, String> {
    Optional<StockImageEntity> findByStockcode(String stockcode);
}
