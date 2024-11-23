package codeping.flex.stock.application.port.in;

import codeping.flex.stock.application.port.in.dto.GetStockAutoCompleteDto;

import java.util.List;

public interface StockSearchUsecase {
    List<GetStockAutoCompleteDto> autoCompleteStockcode(String prefix, int size);
    List<GetStockAutoCompleteDto> autoCompleteCorpName(String prefix, int size);
}
