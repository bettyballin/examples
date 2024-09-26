import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CustomSecurityAnnotationInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod && ((HandlerMethod) handler).getMethod().isAnnotationPresent(CustomSecurityAnnotation.class)) {
            // Your custom security logic here

            String authorizationHeader = request.getHeader("Authorization");

            boolean isAuthorized = validateToken(authorizationHeader);

            if (!isAuthorized) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized access.");

                return false;
            }
        }

        // Continue with the request

        return true;
    }

    private boolean validateToken(String token) {
        // Your custom validation logic here
        // Example validation logic (replace with your actual logic)
        if (token != null && token.equals("valid-token")) {
            return true;
        } else {
            return false;
        }
    }
}

// CustomSecurityAnnotation.java
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CustomSecurityAnnotation {
}