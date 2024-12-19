package codeping.flex.stock.global.common.response.code;

import org.springframework.http.HttpStatus;

public interface BaseErrorCode {
    String name();
    HttpStatus getHttpStatus();
    String getCustomCode();
    String getMessage();
}
