package codeping.flex.stock.global.annotation.swagger;

import codeping.flex.stock.domain.execption.StockErrorCode;
import codeping.flex.stock.domain.execption.UserErrorCode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiErrorCodes {
	UserErrorCode[] userErrors() default {};
	StockErrorCode[] stockErrors() default {};
}
