import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Temp337 {

    public static void main(String[] args) {
        // Entry point for the application, usually for a Spring Boot application
    }

    @RequestMapping(value = "/someUrl", method = RequestMethod.GET)
    public ModelAndView someRequestHandler(@AuthenticationPrincipal User activeUser) {
        // Your logic here
        return new ModelAndView("viewName");
    }

    // Dummy User class for demonstration purposes
    public static class User {
        // User properties and methods
    }
}