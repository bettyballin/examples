import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class Temp286 {

    private UserService userService; // Assume UserService is a defined service

    public Temp286(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        // Spring Boot application would typically be started here
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView indexPage(Map<String, Object> map) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            map.put("localList", userService.findLoggedInUsersLocals(auth.getName()));
        }

        return new ModelAndView("home");
    }
}