package codeping.flex.stock.application.port.out;

import codeping.flex.stock.domain.CorpInfo;

import java.util.Optional;

public interface LoadCorpInfoPort {
    Optional<CorpInfo> loadByStockcode(String stockcode);
}
