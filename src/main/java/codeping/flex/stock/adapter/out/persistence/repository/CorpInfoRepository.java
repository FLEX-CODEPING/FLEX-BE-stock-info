package codeping.flex.stock.adapter.out.persistence.repository;

import codeping.flex.stock.adapter.out.persistence.entity.CorpInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CorpInfoRepository extends JpaRepository<CorpInfoEntity, String> {
    Optional<CorpInfoEntity> findByStockcode(String stockcode);
}
