package codeping.flex.stock.application;

import codeping.flex.stock.adapter.out.persistence.entity.pk.StockIDEntity;
import codeping.flex.stock.adapter.out.persistence.mapper.StockIDMapper;
import codeping.flex.stock.application.mapper.GetStockInfoResponseMapper;
import codeping.flex.stock.application.port.in.StockInfoUsecase;
import codeping.flex.stock.application.port.in.dto.GetStockPreMarketInfoDto;
import codeping.flex.stock.application.port.in.dto.GetStockPreOpenSummaryInfoDto;
import codeping.flex.stock.application.port.in.dto.GetStockSummaryInfoDto;
import codeping.flex.stock.application.port.out.*;
import codeping.flex.stock.domain.*;
import codeping.flex.stock.domain.execption.StockErrorCode;
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

    private final GetStockInfoResponseMapper getStockInfoResponseMapper;
    private final StockIDMapper stockIDMapper;

    @Override
    public GetStockSummaryInfoDto getStockSummaryInfo(String stockcode) {
        CorpInfo stockWithCorpInfo = getStockWithCorpInfo(stockcode);
        return getStockInfoResponseMapper.toGetStockSummaryInfoDto(stockWithCorpInfo);
    }

    @Override
    public GetStockPreOpenSummaryInfoDto getStockPreOpenSummaryInfo(String stockcode, LocalDate date) {
        CorpInfo corpInfo = getStockWithCorpInfo(stockcode);
        StockIDEntity stockIDEntity = stockIDMapper.toEntity(stockcode, date);
        StockOHLCV stockOHLCV = getStockOHLCV(stockIDEntity);
        return getStockInfoResponseMapper.toGetStockSummaryPreMarketInfoDto(stockOHLCV, corpInfo, date);
    }

    private Stock getStock(String stockcode) {
        return loadStockPort.loadByStockCode(stockcode).orElseThrow(() ->
                ApplicationException.from(StockErrorCode.STOCK_NOT_FOUND));
    }

    private CorpInfo getStockWithCorpInfo(String stockcode) {
        return loadCorpInfoPort.loadByStockcode(stockcode).orElse(null);
    }

    @Override
    public GetStockPreMarketInfoDto getStockPreMarketInfo(String stockcode, LocalDate date) {
        StockIDEntity stockIDEntity = stockIDMapper.toEntity(stockcode, date);
        StockOHLCV stockOHLCV = getStockOHLCV(stockIDEntity);
        StockMarketCap stockMarketCap = getStockMarketCap(stockIDEntity);
        return getStockInfoResponseMapper.toGetStockPreMarketInfoDto(stockOHLCV, stockMarketCap);
    }

    private StockMarketCap getStockMarketCap(StockIDEntity stockIDEntity) {
        return loadStockMarketCapPort.loadByStockCodeAndDate(stockIDEntity).orElseThrow(
                () -> ApplicationException.from(StockErrorCode.STOCK_MARKET_CAP_NOT_FOUND));
    }

    private StockOHLCV getStockOHLCV(StockIDEntity stockIDEntity) {
        StockOHLCV stockOHLCV = loadStockOHLCVPort.loadByStockCodeAndDate(stockIDEntity).orElseThrow(
                () -> ApplicationException.from(StockErrorCode.STOCK_OHLCV_NOT_FOUND));
        ;
        return stockOHLCV;
    }

}
