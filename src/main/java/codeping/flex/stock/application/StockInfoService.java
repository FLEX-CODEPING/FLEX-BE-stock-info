package codeping.flex.stock.application;

import codeping.flex.stock.adapter.out.entity.pk.StockIDEntity;
import codeping.flex.stock.adapter.out.mapper.StockIDMapper;
import codeping.flex.stock.application.mapper.GetStockInfoMapper;
import codeping.flex.stock.application.port.in.StockInfoUsecase;
import codeping.flex.stock.application.port.in.dto.GetStockMarketCapInfoDto;
import codeping.flex.stock.application.port.in.dto.GetStockOHLCVInfoDto;
import codeping.flex.stock.application.port.in.dto.GetStockSummaryInfoDto;
import codeping.flex.stock.adapter.out.mapper.StockMapper;
import codeping.flex.stock.adapter.out.mapper.StockOHLCVMapper;
import codeping.flex.stock.domain.Stock;
import codeping.flex.stock.domain.StockID;
import codeping.flex.stock.domain.StockMarketCap;
import codeping.flex.stock.domain.StockOHLCV;
import codeping.flex.stock.application.port.out.LoadStockMarketCapPort;
import codeping.flex.stock.application.port.out.LoadStockOHLCVPort;
import codeping.flex.stock.application.port.out.LoadStockPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StockInfoService implements StockInfoUsecase {
    private final LoadStockPort loadStockPort;
    private final LoadStockOHLCVPort loadStockOHLCVPort;
    private final LoadStockMarketCapPort loadStockMarketCapPort;

    // TODO: 관심 종목 여부, 이미지 데이터 받아와야함
    @Override
    public GetStockSummaryInfoDto getStockInfo(String stockcode) {
        Stock stock = StockMapper.toDomain(loadStockPort.getStock(stockcode));
        return GetStockInfoMapper.toGetStockInfoDto(stock, null);
    }

    @Override
    public GetStockOHLCVInfoDto getStockOHLCVInfo(String stockcode) {
        StockID stockID = getStockID(stockcode);
        StockIDEntity stockIDEntity = StockIDMapper.toEntity(stockID);
        StockOHLCV stockOHLCV = StockOHLCVMapper.toDomain(loadStockOHLCVPort.getStockOHLCV(stockIDEntity));
        return GetStockInfoMapper.toGetStockOHLCVInfoDto(stockOHLCV);
    }

    @Override
    public GetStockMarketCapInfoDto getStockMarketCapInfo(String stockcode) {
        StockID stockID = getStockID(stockcode);
        StockIDEntity stockIDEntity = StockIDMapper.toEntity(stockID);
        StockMarketCap stockMarketCap = loadStockMarketCapPort.getStockMarketCap(stockIDEntity);
        return GetStockInfoMapper.toGetStockMarketCapInfoDto(stockMarketCap);
    }

    private StockID getStockID(String stockcode) {
        return StockID.builder()
                .stockcode(stockcode)
                .date(LocalDate.now().minusDays(1))
                .build();
    }
}
