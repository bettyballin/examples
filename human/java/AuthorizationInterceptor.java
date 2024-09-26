import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

    @Autowired
    private IUserSession userSession;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("interceptor called for " + request.getRequestURI());
        if (userSession.isSessionValid()) {
            System.out.println("ready to enter");
            return true;
        } else {
            System.out.println("not logged in...redirecting to login");
            response.sendRedirect("/in_development_page");
            return false;
        }
    }
}

interface IUserSession {
    boolean isSessionValid();
}

@Component
class UserSession implements IUserSession {
    @Override
    public boolean isSessionValid() {
        // Stub method for session validation
        return false;
    }
}