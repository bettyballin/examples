import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private IUserSession userSession;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Interceptor called for " + request.getRequestURI());
        if (userSession.isSessionValid()) {
            System.out.println("Ready to enter");
            return true;
        } else {
            System.out.println("Not logged in...redirecting to login");
            response.sendRedirect("/in_development_page");
            return false;
        }
    }
}