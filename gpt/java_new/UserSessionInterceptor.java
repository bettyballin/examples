import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class UserSessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("currUser");
        DBsession dbSession = (DBsession) session.getAttribute("DBsession");

        if (u == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }

        request.setAttribute("currUser", u);
        request.setAttribute("DBsession", dbSession);

        return true;
    }

    // Implement other methods if needed, like postHandle or afterCompletion
}