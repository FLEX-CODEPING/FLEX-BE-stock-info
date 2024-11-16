package codeping.flex.stock.global.annotation;

import codeping.flex.stock.global.StockErrorCode;
import codeping.flex.stock.global.UserErrorCode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiErrorCodes {
	UserErrorCode[] userErrors();
	StockErrorCode[] stockErrors();
}
