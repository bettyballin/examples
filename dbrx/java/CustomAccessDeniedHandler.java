import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@Component
public class CustomAccessDeniedHandler implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        // Get the handler method that threw an exception.
        HandlerMethod handlerMethod = (HandlerMethod) request.getAttribute(DispatcherServlet.HANDLER_ATTRIBUTE);

        if (handlerMethod != null && hasAllowedForSystemUsersAnnotation(handlerMethod)) {
            // Handle AccessDeniedException caused by @AllowedForSystemUsers annotation
            response.sendRedirect("/error");
       } else {
           // Default handling for other cases.
           response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access denied.");
        }
    }

    private boolean hasAllowedForSystemUsersAnnotation(HandlerMethod handlerMethod) {
        Method method = handlerMethod.getMethod();
        return AnnotationUtils.findAnnotation(method, AllowedForSystemUsers.class) != null;
    } 
}