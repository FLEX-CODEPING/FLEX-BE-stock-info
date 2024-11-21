package codeping.flex.stock.application.port.out;

import codeping.flex.stock.domain.InterestStock;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.Optional;

public interface InterestStockPort {
    InterestStock save(InterestStock interestStock);
    Optional<InterestStock> findByUserIdAndStockcode(String stockcode, Long userId);
    boolean existsByIdAndUserId(Long id, Long userId);
    boolean existsByStockcodeAndUserId(String stockcode, Long userId);
    void deleteById(Long id);
    Slice<InterestStock> findByUserId(Long userId, Pageable pageable);
}
