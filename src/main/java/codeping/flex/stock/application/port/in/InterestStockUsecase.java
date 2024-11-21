package codeping.flex.stock.application.port.in;

import codeping.flex.stock.application.port.in.dto.GetInterestStockInfoDto;
import codeping.flex.stock.global.common.response.SliceResponse;

public interface InterestStockUsecase {
    String addInterest(String stockCode, Long userId);
    void removeInterest(Long interestStockId, Long userId);
    String getIsInterest(String stockCode, Long userId);
    SliceResponse<GetInterestStockInfoDto> getInterestStocks(Long userId, int page, int size);
}
