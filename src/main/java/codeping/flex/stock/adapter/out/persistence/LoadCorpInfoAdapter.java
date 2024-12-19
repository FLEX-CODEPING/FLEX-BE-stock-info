package codeping.flex.stock.adapter.out.persistence;

import codeping.flex.stock.adapter.out.persistence.mapper.CorpInfoMapper;
import codeping.flex.stock.adapter.out.persistence.repository.CorpInfoRepository;
import codeping.flex.stock.application.port.out.LoadCorpInfoPort;
import codeping.flex.stock.domain.CorpInfo;
import codeping.flex.stock.global.annotation.architecture.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class LoadCorpInfoAdapter implements LoadCorpInfoPort {
    private final CorpInfoRepository corpInfoRepository;
    private final CorpInfoMapper corpInfoMapper;

    public Optional<CorpInfo> loadByStockcode(String stockcode) {
        return corpInfoRepository.findByStockcode(stockcode)
                .map(corpInfoMapper::toDomain);
    }
}
