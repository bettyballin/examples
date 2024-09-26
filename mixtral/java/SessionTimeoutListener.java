import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.ModelAndView;
import java.io.IOException;

public class SessionTimeoutListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {}

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // Set the flag to indicate that this is a timeout
        se.getSession().setAttribute("isExpired", true);
    }
}

public class SessionTimeoutInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getAttribute("isExpired") != null && (Boolean) request.getAttribute("isExpired")) {
            // Redirect to login page with error message
            response.sendRedirect("/login?error=session_expired");
            return false;
        }
        return true;
    }
}