package codeping.flex.stock.application;

import codeping.flex.stock.application.mapper.GetStockAutoCompleteDtoMapper;
import codeping.flex.stock.application.port.in.StockSearchUsecase;
import codeping.flex.stock.adapter.in.dto.GetStockAutoCompleteDto;
import codeping.flex.stock.application.port.out.SearchStockDocumentPort;
import codeping.flex.stock.global.annotation.architecture.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNumeric;

@ApplicationService
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StockSearchService implements StockSearchUsecase {
    private final SearchStockDocumentPort searchStockDocumentPort;
    private final GetStockAutoCompleteDtoMapper getStockAutoCompleteDtoMapper;

    @Override
    public List<GetStockAutoCompleteDto> getAutoCompleteStocks(String prefix, int size){
        PageRequest pageRequest = PageRequest.of(0, size);
        if (isNumeric(prefix)) {
            return autoCompleteByStockcode(prefix, pageRequest);
        }
        return autoCompleteByStockName(prefix, pageRequest);
    }

    @Override
    public List<GetStockAutoCompleteDto> getAutoCompleteStocks(String searchType, String prefix, int size){
        PageRequest pageRequest = PageRequest.of(0, size);
        if(searchType.equals("stockcode")){
            return autoCompleteByStockcode(prefix, pageRequest);
        }
        else if(searchType.equals("stockName")){
            return autoCompleteByStockName(prefix, pageRequest);
        }
        else return null;
    }

    private List<GetStockAutoCompleteDto> autoCompleteByStockcode(String prefix, PageRequest pageRequest) {
        return searchStockDocumentPort.findByStockcodePrefix(prefix, pageRequest)
                .stream().map(getStockAutoCompleteDtoMapper::toDto)
                .toList();
    }

    private List<GetStockAutoCompleteDto> autoCompleteByStockName(String prefix, PageRequest pageRequest) {
        return searchStockDocumentPort.findByStockNamePrefix(prefix, pageRequest)
                .stream().map(getStockAutoCompleteDtoMapper::toDto)
                .toList();
    }
}


