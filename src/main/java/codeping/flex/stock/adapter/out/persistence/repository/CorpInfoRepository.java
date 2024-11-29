package codeping.flex.stock.adapter.out.persistence.repository;

import codeping.flex.stock.adapter.out.persistence.entity.stockData.CorpInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CorpInfoRepository extends JpaRepository<CorpInfoEntity, String> {

    @Query("SELECT ci FROM CorpInfoEntity ci LEFT JOIN FETCH ci.stock WHERE ci.stockcode = :stockcode")
    Optional<CorpInfoEntity> findByStockcode(@Param("stockcode") String stockcode);
}
