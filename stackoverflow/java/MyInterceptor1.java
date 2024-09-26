import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyInterceptor1 extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!request.getMethod().equalsIgnoreCase("POST") && !request.getMethod().equalsIgnoreCase("GET")) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Unauthorized Request");
            return false;
        }
        return true;
    }
}