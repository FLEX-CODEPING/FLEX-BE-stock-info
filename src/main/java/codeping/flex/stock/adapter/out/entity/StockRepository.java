package codeping.flex.stock.adapter.out.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository extends JpaRepository<StockEntity, String> {
    Optional<StockEntity> findByStockcode(String stockcode);
}
