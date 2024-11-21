package codeping.flex.stock.adapter.out.persistence;

import codeping.flex.stock.adapter.out.persistence.entity.InterestStockEntity;
import codeping.flex.stock.adapter.out.persistence.mapper.InterestStockMapper;
import codeping.flex.stock.adapter.out.persistence.repository.InterestStockRepository;
import codeping.flex.stock.application.port.out.InterestStockPort;
import codeping.flex.stock.domain.InterestStock;
import codeping.flex.stock.global.annotation.architecture.PersistenceAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.Optional;


@Slf4j
@PersistenceAdapter
@RequiredArgsConstructor
public class InterestStockAdapter implements InterestStockPort {

    private final InterestStockRepository interestStockRepository;
    private final InterestStockMapper interestStockMapper;

    @Override
    public InterestStock save(InterestStock interestStock) {
        InterestStockEntity entity = interestStockMapper.toEntity(interestStock);
        return interestStockMapper.toDomain(interestStockRepository.save(entity));
    }

    @Override
    public Optional<InterestStock> findByUserIdAndStockcode(String stockcode, Long userId) {
        return interestStockRepository.findByUserIdAndStockcode(userId, stockcode)
                .map(interestStockMapper::toDomain);
    }

    @Override
    public boolean existsByIdAndUserId(Long id, Long userId) {
        return interestStockRepository.existsByIdAndUserId(id, userId);
    }

    @Override
    public boolean existsByStockcodeAndUserId(String stockcode, Long userId) {
        return interestStockRepository.existsByStockcodeAndUserId(stockcode, userId);
    }

    @Override
    public void deleteById(Long id) {
        interestStockRepository.deleteById(id);
    }

    @Override
    public Slice<InterestStock> findByUserId(Long userId, Pageable pageable) {
        return interestStockRepository.findByUserIdOrderByCreatedAtDesc(userId, pageable).map(interestStockMapper::toDomain);
    }
}
