import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Define the ValidateHeader annotation
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateHeader {
    String name();
}

// Implement the HeaderValidationInterceptor
@Component
public class HeaderValidationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            ValidateHeader validateHeader = ((HandlerMethod) handler).getMethodAnnotation(ValidateHeader.class);

            if (validateHeader != null) {
                // Check for the required header
                String headerValue = request.getHeader(validateHeader.name());
                if (headerValue == null) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing header: " + validateHeader.name());
                    return false;
                }
            }
        }
        return true;
    }
}

// Configure the interceptor in the WebMvcConfigurer
@Component
public class WebConfig implements WebMvcConfigurer {

    private final HeaderValidationInterceptor headerValidationInterceptor;

    public WebConfig(HeaderValidationInterceptor headerValidationInterceptor) {
        this.headerValidationInterceptor = headerValidationInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(headerValidationInterceptor);
    }
}