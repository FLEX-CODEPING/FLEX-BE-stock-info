package codeping.flex.stock.application.port.in;

import codeping.flex.stock.adapter.in.dto.InterestStockInfoDto;
import codeping.flex.stock.global.common.response.SliceResponse;

public interface InterestStockUsecase {
    String addInterest(String stockCode, Long userId);
    void removeInterest(Long interestStockId, Long userId);
    String getIsInterest(String stockCode, Long userId);
    SliceResponse<InterestStockInfoDto> getInterestStocks(Long userId, int page, int size);
    Long getDecodedId(String encodedId);
}
