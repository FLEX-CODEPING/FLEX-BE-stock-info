package codeping.flex.stock.global;

import codeping.flex.stock.global.common.response.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum StockErrorCode implements BaseErrorCode {

    STOCK_NOT_FOUND(HttpStatus.NOT_FOUND, "STOCK_001", "해당 주식 ticker 정보를 찾을 수 없습니다."),
    STOCK_OHLCV_NOT_FOUND(HttpStatus.NOT_FOUND, "STOCK_002", "해당 주식 OHLCV 정보를 찾을 수 없습니다."),
    STOCK_MARKET_CAP_NOT_FOUND(HttpStatus.NOT_FOUND, "STOCK_003", "해당 주식 시가총액 정보를 찾을 수 없습니다."),
    INTEREST_STOCK_BAD_REQUEST(HttpStatus.BAD_REQUEST, "STOCK_004", "종목 정보가 없거나, 관심 주식 접근 권한이 없습니다."),
    DUPLICATE_INTEREST_STOCK(HttpStatus.CONFLICT, "STOCK_005", "중복된 관심 종목 등록입니다.")
    ;
    private final HttpStatus httpStatus;
    private final String customCode;
    private final String message;
}
