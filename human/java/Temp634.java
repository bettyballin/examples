import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Temp634 {

    public static void main(String[] args) {
        // Since this is a Spring MVC controller, the main method is not used to execute the application.
        // The Spring framework will handle the lifecycle and calls to the controller methods.
    }

    @RequestMapping(value = {"/login/failure"}, method = RequestMethod.GET)
    public ModelAndView renderLoginFailureView(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("login");
        AuthenticationException authEx = (AuthenticationException) request.getSession().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);

        if (authEx != null) {
            mav.addObject("authEx", authEx.getMessage());
        } else {
            mav.addObject("authEx", "Unknown error");
        }
        return mav;
    }
}