package codeping.flex.stock.application.port.in;

import codeping.flex.stock.application.port.in.dto.GetInterestStockInfoDto;
import codeping.flex.stock.global.common.response.SliceResponse;

public interface InterestStockUsecase {
    void addInterest(String stockCode, Long userId);
    void removeInterest(Long interestStockId, Long userId);
    boolean getIsInterest(String stockCode, Long userId);
    SliceResponse<GetInterestStockInfoDto> getInterestStocks(Long userId, int page, int size);
}
