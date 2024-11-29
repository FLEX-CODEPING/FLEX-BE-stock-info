package codeping.flex.stock.application;

import codeping.flex.stock.adapter.in.dto.StockPreMarketInfoDto;
import codeping.flex.stock.adapter.in.dto.StockPreOpenSummaryInfoDto;
import codeping.flex.stock.adapter.out.persistence.entity.stockData.pk.StockIDEntity;
import codeping.flex.stock.adapter.out.persistence.mapper.StockIDMapper;
import codeping.flex.stock.application.mapper.StockInfoResponseMapper;
import codeping.flex.stock.application.port.in.StockInfoUsecase;
import codeping.flex.stock.adapter.in.dto.StockSummaryInfoDto;
import codeping.flex.stock.application.port.out.*;
import codeping.flex.stock.domain.execption.StockErrorCode;
import codeping.flex.stock.domain.stockData.CorpInfo;
import codeping.flex.stock.domain.stockData.Stock;
import codeping.flex.stock.domain.stockData.StockMarketCap;
import codeping.flex.stock.domain.stockData.StockOHLCV;
import codeping.flex.stock.global.annotation.architecture.ApplicationService;
import codeping.flex.stock.global.common.exception.ApplicationException;
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
    private final LoadCorpInfoPort loadCorpInfoPort;

    private final StockInfoResponseMapper stockInfoResponseMapper;
    private final StockIDMapper stockIDMapper;

    @Override
    public StockSummaryInfoDto getStockSummaryInfo(String stockcode) {
        CorpInfo stockWithCorpInfo = getStockWithCorpInfo(stockcode);
        return stockInfoResponseMapper.toGetStockSummaryInfoDto(stockWithCorpInfo);
    }

    @Override
    public StockPreOpenSummaryInfoDto getStockPreOpenSummaryInfo(String stockcode, LocalDate date) {
        CorpInfo corpInfo = getStockWithCorpInfo(stockcode);
        StockIDEntity stockIDEntity = stockIDMapper.toEntity(stockcode, date);
        StockOHLCV stockOHLCV = getStockOHLCV(stockIDEntity);
        return stockInfoResponseMapper.toGetStockSummaryPreMarketInfoDto(stockOHLCV, corpInfo, date);
    }

    private Stock getStock(String stockcode) {
        return loadStockPort.loadByStockCode(stockcode).orElseThrow(() ->
                ApplicationException.from(StockErrorCode.STOCK_NOT_FOUND));
    }

    private CorpInfo getStockWithCorpInfo(String stockcode) {
        return loadCorpInfoPort.loadByStockcode(stockcode).orElse(null);
    }

    @Override
    public StockPreMarketInfoDto getStockPreMarketInfo(String stockcode, LocalDate date) {
        StockIDEntity stockIDEntity = stockIDMapper.toEntity(stockcode, date);
        StockOHLCV stockOHLCV = getStockOHLCV(stockIDEntity);
        StockMarketCap stockMarketCap = getStockMarketCap(stockIDEntity);
        return stockInfoResponseMapper.toGetStockPreMarketInfoDto(stockOHLCV, stockMarketCap);
    }

    private StockMarketCap getStockMarketCap(StockIDEntity stockIDEntity) {
        return loadStockMarketCapPort.loadByStockCodeAndDate(stockIDEntity).orElse(null);
    }

    private StockOHLCV getStockOHLCV(StockIDEntity stockIDEntity) {
        return loadStockOHLCVPort.loadByStockCodeAndDate(stockIDEntity).orElse(null);
    }

}

