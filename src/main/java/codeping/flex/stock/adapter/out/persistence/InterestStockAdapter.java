package codeping.flex.stock.adapter.out.persistence;

import codeping.flex.stock.adapter.out.persistence.entity.InterestStockEntity;
import codeping.flex.stock.adapter.out.persistence.mapper.InterestStockMapper;
import codeping.flex.stock.adapter.out.persistence.repository.InterestStockRepository;
import codeping.flex.stock.application.port.out.InterestStockPort;
import codeping.flex.stock.domain.InterestStock;
import codeping.flex.stock.global.annotation.architecture.PersistenceAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@PersistenceAdapter
@RequiredArgsConstructor
public class InterestStockAdapter implements InterestStockPort {

    private final InterestStockRepository interestStockRepository;
    private final InterestStockMapper interestStockMapper;

    @Override
    public void save(InterestStock interestStock) {
        InterestStockEntity entity = interestStockMapper.toEntity(interestStock);
        log.info("interestStock {}: {}", interestStock.getStockcode(), entity.getStockcode());
        interestStockRepository.save(entity);
    }

    @Override
    public Optional<InterestStock> loadByIdAndUserId(Long id, Long userId) {
        return interestStockRepository.findByIdAndUserId(id, userId)
                .map(interestStockMapper::toDomain);
    }

    @Override
    public void deleteById(Long id) {
        interestStockRepository.deleteById(id);
    }
}
