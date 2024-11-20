package codeping.flex.stock.application.port.out;

import codeping.flex.stock.domain.InterestStock;

public interface InterestStockPort {
    void save(InterestStock interestStock);
    boolean existsByIdAndUserId(Long id, Long userId);
    boolean existsByStockcodeAndUserId(String stockcode, Long userId);
    void deleteById(Long id);
}
