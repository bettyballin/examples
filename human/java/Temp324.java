import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

public class Temp324 {
    public static void main(String[] args) {
        // This is a placeholder for the main method.
        // You should call someRequestHandler method from a Spring controller or another component.
    }

    public ModelAndView someRequestHandler(Principal principal) {
        User activeUser = (User) ((Authentication) principal).getPrincipal();
        // Handle request and return appropriate ModelAndView
        return new ModelAndView("viewName");
    }
}