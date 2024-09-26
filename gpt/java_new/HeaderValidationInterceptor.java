import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.http.HttpStatus;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface ValidateHeader {
    String name();
}

@Component
public class HeaderValidationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            ValidateHeader validateHeader = handlerMethod.getMethodAnnotation(ValidateHeader.class);
            if (validateHeader != null) {
                String headerName = validateHeader.name();
                String headerValue = request.getHeader(headerName);

                if (headerValue == null || !isValid(headerValue)) {
                    response.setStatus(HttpStatus.BAD_REQUEST.value());
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(String headerValue) {
        // Replace with actual validation logic
        return headerValue != null && !headerValue.trim().isEmpty();
    }
}