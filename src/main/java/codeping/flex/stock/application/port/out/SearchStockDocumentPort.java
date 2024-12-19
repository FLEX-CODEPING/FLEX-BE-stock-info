package codeping.flex.stock.application.port.out;

import codeping.flex.stock.domain.StockDocumentDomain;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SearchStockDocumentPort {

    List<StockDocumentDomain> findByStockcodePrefix(String prefix, Pageable pageable);

    List<StockDocumentDomain> findByStockNamePrefix(String stockName, Pageable pageable);
}
