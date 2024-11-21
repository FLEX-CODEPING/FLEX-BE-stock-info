package codeping.flex.stock.adapter.out.persistence.repository;

import codeping.flex.stock.adapter.out.persistence.entity.InterestStockEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InterestStockRepository extends JpaRepository<InterestStockEntity, Long> {
    boolean existsByIdAndUserId(Long id, Long userId);
    boolean existsByStockcodeAndUserId(String stockcode, Long userId);
    Slice<InterestStockEntity> findByUserIdOrderByCreatedAtDesc(Long userId, Pageable pageable);
    Optional<InterestStockEntity> findByUserIdAndStockcode(Long userId, String stockcode);
}
