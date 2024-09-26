import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class ValidateHeaderAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidateHeaderAspect.class);

    @Before("@annotation(validateHeader)")
    public void validateCustomHeader(JoinPoint joinPoint, ValidateHeader validateHeader) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String headerValue = request.getHeader(validateHeader.name());

        if (headerValue == null || !isValidHeaderValue(headerValue)) { 
            LOGGER.error("Invalid or missing custom header: {}", validateHeader.name());
            throw new RuntimeException("Invalid or missing custom header");
        }
    }

    private boolean isValidHeaderValue(String value) {
        return true;
    }
}

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ValidateHeader {
    String name();
}