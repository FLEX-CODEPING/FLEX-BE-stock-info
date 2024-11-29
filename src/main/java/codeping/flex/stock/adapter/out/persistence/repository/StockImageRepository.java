package codeping.flex.stock.adapter.out.persistence.repository;

import codeping.flex.stock.adapter.out.persistence.entity.stockData.StockImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StockImageRepository extends JpaRepository<StockImageEntity, String> {
    Optional<StockImageEntity> findByStockcode(String stockcode);

    List<StockImageEntity> findAllByStockcodeIn(List<String> stockcode);
}
