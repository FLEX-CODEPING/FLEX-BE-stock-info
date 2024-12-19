package codeping.flex.stock.adapter.out.persistence.repository;

import codeping.flex.stock.adapter.out.persistence.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StockRepository extends JpaRepository<StockEntity, String> {
    Optional<StockEntity> findByStockcode(String stockcode);
    List<StockEntity> findAllByStockcodeIn(List<String> stockcodes);
}
