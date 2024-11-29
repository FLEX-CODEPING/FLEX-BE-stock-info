package codeping.flex.stock.adapter.out.persistence;

import codeping.flex.stock.adapter.out.persistence.mapper.StockDocumentMapper;
import codeping.flex.stock.application.port.out.SearchStockDocumentPort;
import codeping.flex.stock.domain.stockData.StockDocumentDomain;
import codeping.flex.stock.global.annotation.architecture.PersistenceAdapter;
import codeping.flex.stock.infrastructure.elasticsearch.repository.StockDocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
public class SearchStockDocumentAdapter implements SearchStockDocumentPort {
    private final StockDocumentRepository stockDocumentRepository;
    private final StockDocumentMapper stockDocumentMapper;

    @Override
    public List<StockDocumentDomain> findByStockcodePrefix(String stockcode , Pageable pageable) {
        return stockDocumentRepository.findByStockcodePrefix(stockcode, pageable)
                .stream().map(stockDocumentMapper::toDomain)
                .toList();
    }

    @Override
    public List<StockDocumentDomain> findByStockNamePrefix(String stockName, Pageable pageable) {
        return stockDocumentRepository.findByStockNamePrefix(stockName, pageable)
                .stream().map(stockDocumentMapper::toDomain)
                .toList();
    }
}
