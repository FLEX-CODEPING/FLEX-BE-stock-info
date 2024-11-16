package codeping.flex.stock.global.annotation;

import codeping.flex.stock.global.common.response.PassportInfo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class PassportResolver implements HandlerMethodArgumentResolver {

    private static final String PASSPORT_HEADER_PREFIX = "x-pp-";

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(codeping.flex.stock.global.annotation.Passport.class)
                && PassportInfo.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(
            MethodParameter parameter,
            ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory
    ) {
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);

        PassportInfo passportInfo = new PassportInfo(
                Long.valueOf(request.getHeader(PASSPORT_HEADER_PREFIX + "userKey")),
                request.getHeader(PASSPORT_HEADER_PREFIX + "email"),
                request.getHeader(PASSPORT_HEADER_PREFIX + "role"),
                request.getHeader(PASSPORT_HEADER_PREFIX + "profileImage")
        );

        return passportInfo;
    }
}

