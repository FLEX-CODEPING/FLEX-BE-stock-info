package codeping.flex.stock.adapter.out.persistence;

import codeping.flex.stock.adapter.out.persistence.mapper.StockImageMapper;
import codeping.flex.stock.adapter.out.persistence.repository.StockImageRepository;
import codeping.flex.stock.application.port.out.LoadStockImagePort;
import codeping.flex.stock.domain.stockData.StockImage;
import codeping.flex.stock.global.annotation.architecture.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class LoadStockImageAdapter implements LoadStockImagePort {
    private final StockImageRepository stockImageRepository;
    private final StockImageMapper stockImageMapper;

    @Override
    public Optional<StockImage> loadByStockCode(String stockcode) {
        return stockImageRepository.findByStockcode(stockcode)
                .map(stockImageMapper::toDomain);
    }

    @Override
    public List<StockImage> loadAllByStockCode(List<String> stockcodes) {
        return stockImageRepository.findAllByStockcodeIn(stockcodes)
                .stream().map(stockImageMapper::toDomain).toList();
    }
}
