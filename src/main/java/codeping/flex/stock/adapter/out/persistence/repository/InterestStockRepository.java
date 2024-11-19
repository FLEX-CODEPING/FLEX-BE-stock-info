package codeping.flex.stock.adapter.out.persistence.repository;

import codeping.flex.stock.adapter.out.persistence.entity.InterestStockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestStockRepository extends JpaRepository<InterestStockEntity, Long> {
    boolean existsByIdAndUserId(Long id, Long userId);
    boolean existsByStockcodeAndUserId(String stockcode, Long userId);
}
