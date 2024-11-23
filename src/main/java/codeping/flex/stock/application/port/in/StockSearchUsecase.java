package codeping.flex.stock.application.port.in;

import codeping.flex.stock.application.port.in.dto.GetStockAutoCompleteDto;

import java.util.List;

public interface StockSearchUsecase {

    List<GetStockAutoCompleteDto> getAutoCompleteStocks(String prefix, int size);
    List<GetStockAutoCompleteDto> getAutoCompleteStocks(String searchType, String prefix, int size);
}
