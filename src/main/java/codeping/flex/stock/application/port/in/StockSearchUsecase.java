package codeping.flex.stock.application.port.in;

import codeping.flex.stock.adapter.in.dto.StockAutoCompleteDto;

import java.util.List;

public interface StockSearchUsecase {

    List<StockAutoCompleteDto> getAutoCompleteStocks(String prefix, int size);
    List<StockAutoCompleteDto> getAutoCompleteStocks(String searchType, String prefix, int size);
}
