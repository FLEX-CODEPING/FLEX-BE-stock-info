package codeping.flex.stock.infrastructure.elasticsearch.repository;

import codeping.flex.stock.infrastructure.elasticsearch.document.StockDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface StockDocumentRepository extends ElasticsearchRepository<StockDocument, String> {

    @Query("{\"match_phrase_prefix\": {\"stockcode\": \"?0\"}}")
    Page<StockDocument> findByStockcodePrefix(String prefix, Pageable pageable);

    @Query("{\"match_phrase_prefix\": {\"corp_name\": \"?0\"}}")
    Page<StockDocument> findByStockNamePrefix(String stockName, Pageable pageable);
}
