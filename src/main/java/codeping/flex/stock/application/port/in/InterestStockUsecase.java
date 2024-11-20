package codeping.flex.stock.application.port.in;

public interface InterestStockUsecase {
    void addInterest(String stockCode, Long userId);
    void removeInterest(Long interestStockId, Long userId);
}
