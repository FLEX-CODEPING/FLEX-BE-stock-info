package codeping.flex.stock.application;

import codeping.flex.stock.adapter.out.persistence.entity.pk.StockIDEntity;
import codeping.flex.stock.adapter.out.persistence.mapper.StockIDMapper;
import codeping.flex.stock.adapter.out.persistence.mapper.StockImageMapper;
import codeping.flex.stock.adapter.out.persistence.mapper.StockMapper;
import codeping.flex.stock.adapter.out.persistence.mapper.StockOHLCVMapper;
import codeping.flex.stock.application.mapper.GetStockInfoMapper;
import codeping.flex.stock.application.port.in.StockInfoUsecase;
import codeping.flex.stock.application.port.in.dto.GetStockPreMarketInfoDto;
import codeping.flex.stock.application.port.in.dto.GetStockSummaryInfoDto;
import codeping.flex.stock.application.port.out.LoadStockImagePort;
import codeping.flex.stock.application.port.out.LoadStockMarketCapPort;
import codeping.flex.stock.application.port.out.LoadStockOHLCVPort;
import codeping.flex.stock.application.port.out.LoadStockPort;
import codeping.flex.stock.domain.*;
import codeping.flex.stock.global.annotation.architecture.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


@ApplicationService
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StockInfoService implements StockInfoUsecase {
    private final LoadStockPort loadStockPort;
    private final LoadStockOHLCVPort loadStockOHLCVPort;
    private final LoadStockMarketCapPort loadStockMarketCapPort;
    private final LoadStockImagePort loadStockImagePort;

    // TODO: 관심 종목 여부 받아와야함
    @Override
    public GetStockSummaryInfoDto getStockSummaryInfo(String stockcode) {
        Stock stock = StockMapper.toDomain(loadStockPort.loadStock(stockcode));
        StockImage stockImage = StockImageMapper.toDomain(loadStockImagePort.loadStockImage(stockcode));
        return GetStockInfoMapper.toGetStockInfoDto(stock, stockImage);
    }

    @Override
    public GetStockPreMarketInfoDto getStockPreMarketInfo(String stockcode, LocalDate date) {
        StockID stockID = toStockID(stockcode, date);
        StockIDEntity stockIDEntity = StockIDMapper.toEntity(stockID);
        StockOHLCV stockOHLCV = StockOHLCVMapper.toDomain(loadStockOHLCVPort.loadStockOHLCV(stockIDEntity));
        StockMarketCap stockMarketCap = loadStockMarketCapPort.loadStockMarketCap(stockIDEntity);
        return GetStockInfoMapper.toGetStockPreMarketInfoDto(stockOHLCV, stockMarketCap);
    }

    private StockID toStockID(String stockcode, LocalDate date) {
        return StockID.builder()
                .stockcode(stockcode)
                .date(date)
                .build();
    }
}
