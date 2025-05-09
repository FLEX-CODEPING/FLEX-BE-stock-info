package codeping.flex.stock.adapter.out.persistence.repository;

import codeping.flex.stock.adapter.out.persistence.entity.CorpInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CorpInfoRepository extends JpaRepository<CorpInfoEntity, String> {

    Optional<CorpInfoEntity> findByStockcode(@Param("stockcode") String stockcode);
}
