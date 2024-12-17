package codeping.flex.stock.application.port.in;

import codeping.flex.stock.application.port.in.dto.GetStockImageDto;

import java.util.List;

public interface StockImageUsecase {
    List<GetStockImageDto> getStockImageUrls(List<String> stockcodes);
}
