import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class IpRestrictionInterceptor implements HandlerInterceptor {

    private static final String ALLOWED_IP = "192.168.1.1";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            IpRestricted ipRestricted = handlerMethod.getMethodAnnotation(IpRestricted.class);
            if (ipRestricted != null) {
                String clientIp = request.getRemoteAddr();
                if (!ALLOWED_IP.equals(clientIp)) {
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    return false;
                }
            }
        }
        return true;
    }
}