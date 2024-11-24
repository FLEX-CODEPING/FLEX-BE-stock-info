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
    private final LoadStockImagePort loadStockImagePort;
    private final LoadCorpInfoPort loadCorpInfoPort;

    private final GetStockInfoResponseMapper getStockInfoResponseMapper;
    private final StockIDMapper stockIDMapper;

    @Override
    public GetStockSummaryInfoDto getStockSummaryInfo(String stockcode) {
        Stock stock = getStock(stockcode);
        StockImage stockImage = getStockImage(stockcode);
        CorpInfo corpInfo = getCorpInfo(stockcode);
        return getStockInfoResponseMapper.toGetStockSummaryInfoDto(stock, stockImage, corpInfo);
    }

    @Override
    public GetStockPreOpenSummaryInfoDto getStockPreOpenSummaryInfo(String stockcode, LocalDate date) {
        Stock stock = getStock(stockcode);
        StockImage stockImage = getStockImage(stockcode);
        CorpInfo corpInfo = getCorpInfo(stockcode);
        StockOHLCV stockOHLCV = getStockOHLCV(stockcode, date);
        return getStockInfoResponseMapper.toGetStockSummaryPreMarketInfoDto(stock, stockImage, stockOHLCV, corpInfo, date);
    }

    private StockImage getStockImage(String stockcode) {
        return loadStockImagePort.loadByStockCode(stockcode).orElse(null);
    }

    private Stock getStock(String stockcode) {
        return loadStockPort.loadByStockCode(stockcode).orElseThrow(() ->
                ApplicationException.from(StockErrorCode.STOCK_NOT_FOUND));
    }

    private CorpInfo getCorpInfo(String stockcode) {
        return loadCorpInfoPort.loadByStockcode(stockcode).orElse(null);
    }

    @Override
    public GetStockPreMarketInfoDto getStockPreMarketInfo(String stockcode, LocalDate date) {
        StockIDEntity stockIDEntity = stockIDMapper.toEntity(stockcode, date);
        StockOHLCV stockOHLCV = getStockOHLCV(stockcode, date);
        StockMarketCap stockMarketCap = loadStockMarketCapPort.loadByStockCodeAndDate(stockIDEntity).orElseThrow(
                () -> ApplicationException.from(StockErrorCode.STOCK_MARKET_CAP_NOT_FOUND));
        return getStockInfoResponseMapper.toGetStockPreMarketInfoDto(stockOHLCV, stockMarketCap);
    }

    private StockOHLCV getStockOHLCV(String stockcode, LocalDate date) {
        StockIDEntity stockIDEntity = stockIDMapper.toEntity(stockcode, date);
        StockOHLCV stockOHLCV = loadStockOHLCVPort.loadByStockCodeAndDate(stockIDEntity).orElseThrow(
                () -> ApplicationException.from(StockErrorCode.STOCK_OHLCV_NOT_FOUND));
        ;
        return stockOHLCV;
    }

}
