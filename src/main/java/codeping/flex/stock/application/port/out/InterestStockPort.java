package codeping.flex.stock.application.port.out;

import codeping.flex.stock.domain.InterestStock;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface InterestStockPort {
    void save(InterestStock interestStock);
    boolean existsByIdAndUserId(Long id, Long userId);
    boolean existsByStockcodeAndUserId(String stockcode, Long userId);
    void deleteById(Long id);
    Slice<InterestStock> findByUserId(Long userId, Pageable pageable);
}
