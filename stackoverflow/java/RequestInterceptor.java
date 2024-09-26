import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptorAdapter;
import org.springframework.web.servlet.ModelAndView;

public class RequestInterceptor extends HandlerInterceptorAdapter {
    @Override
    public void postHandle(
        HttpServletRequest request,
        HttpServletResponse response,
        Object handler,
        ModelAndView modelAndView) throws Exception {

        // logic here that checks if the user can see something
        boolean abooleanvalue = true; // Replace with actual logic to determine the boolean value
        if(modelAndView != null) { // Check if modelAndView is not null to avoid NullPointerException
            modelAndView.addObject("canUserSeeSection", abooleanvalue);
        }

        super.postHandle(request, response, handler, modelAndView);
    }
}