import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(
        HttpServletRequest request, 
        HttpServletResponse response, 
        Object handler) throws Exception {

        // your logic
        return true;
    }
}