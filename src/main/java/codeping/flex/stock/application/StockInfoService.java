package codeping.flex.stock.application;

import codeping.flex.stock.adapter.out.persistence.entity.pk.StockIDEntity;
import codeping.flex.stock.adapter.out.persistence.mapper.StockIDMapper;
import codeping.flex.stock.application.mapper.GetStockInfoMapper;
import codeping.flex.stock.application.port.in.StockInfoUsecase;
import codeping.flex.stock.application.port.in.dto.GetStockPreMarketInfoDto;
import codeping.flex.stock.application.port.in.dto.GetStockSummaryInfoDto;
import codeping.flex.stock.application.port.out.LoadStockImagePort;
import codeping.flex.stock.application.port.out.LoadStockMarketCapPort;
import codeping.flex.stock.application.port.out.LoadStockOHLCVPort;
import codeping.flex.stock.application.port.out.LoadStockPort;
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
    private final GetStockInfoMapper getStockInfoMapper;
    private final StockIDMapper stockIDMapper;

    @Override
    public GetStockSummaryInfoDto getStockSummaryInfo(String stockcode) {
        Stock stock = loadStockPort.loadByStockCode(stockcode).orElseThrow(()->
                ApplicationException.from(StockErrorCode.STOCK_NOT_FOUND));
        StockImage stockImage = loadStockImagePort.loadByStockCode(stockcode).orElse(null);
        return getStockInfoMapper.toGetStockInfoDto(stock, stockImage);
    }

    @Override
    public GetStockPreMarketInfoDto getStockPreMarketInfo(String stockcode, LocalDate date) {
        StockIDEntity stockIDEntity =stockIDMapper.toEntity(stockcode, date);

        StockOHLCV stockOHLCV = loadStockOHLCVPort.loadByStockCodeAndDate(stockIDEntity).orElseThrow(
                ()-> ApplicationException.from(StockErrorCode.STOCK_OHLCV_NOT_FOUND));;
        StockMarketCap stockMarketCap = loadStockMarketCapPort.loadByStockCodeAndDate(stockIDEntity).orElseThrow(
                () -> ApplicationException.from(StockErrorCode.STOCK_MARKET_CAP_NOT_FOUND));
        return getStockInfoMapper.toGetStockPreMarketInfoDto(stockOHLCV, stockMarketCap);
    }

}
