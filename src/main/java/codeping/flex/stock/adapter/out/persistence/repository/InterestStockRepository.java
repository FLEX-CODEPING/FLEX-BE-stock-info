package codeping.flex.stock.adapter.out.persistence.repository;

import codeping.flex.stock.adapter.out.persistence.entity.InterestStockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InterestStockRepository extends JpaRepository<InterestStockEntity, Long> {
    Optional<InterestStockEntity> findByIdAndUserId(Long id, Long userId);
}
