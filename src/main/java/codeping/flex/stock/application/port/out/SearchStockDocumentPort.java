package codeping.flex.stock.application.port.out;

import codeping.flex.stock.domain.Stock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SearchStockDocumentPort {

    List<Stock> findByStockcodePrefix(String prefix, Pageable pageable);

    List<Stock> findByCorpNamePrefix(String corpName, Pageable pageable);
}
