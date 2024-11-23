package codeping.flex.stock.application;

import codeping.flex.stock.adapter.out.persistence.SearchStockDocumentAdapter;
import codeping.flex.stock.application.mapper.GetStockAutoCompleteDtoMapper;
import codeping.flex.stock.application.port.in.StockSearchUsecase;
import codeping.flex.stock.application.port.in.dto.GetStockAutoCompleteDto;
import codeping.flex.stock.global.annotation.architecture.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ApplicationService
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StockSearchService implements StockSearchUsecase {
    private final SearchStockDocumentAdapter searchStockDocumentAdapter;
    private final GetStockAutoCompleteDtoMapper getStockAutoCompleteDtoMapper;

    @Override
    public List<GetStockAutoCompleteDto> autoCompleteStockcode(String prefix, int size) {
        PageRequest pageRequest = PageRequest.of(0, size);
        return searchStockDocumentAdapter.findByStockcodePrefix(prefix, pageRequest)
                .stream().map(getStockAutoCompleteDtoMapper::toDto)
                .toList();
    }

    @Override
    public List<GetStockAutoCompleteDto> autoCompleteCorpName(String prefix, int size) {
        PageRequest pageRequest = PageRequest.of(0, size);
        return searchStockDocumentAdapter.findByCorpNamePrefix(prefix, pageRequest)
                .stream().map(getStockAutoCompleteDtoMapper::toDto)
                .toList();
    }
}


