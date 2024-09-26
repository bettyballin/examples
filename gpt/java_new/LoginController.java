import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.access.prepost.PreAuthorize;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap map, @RequestParam(value = "fail", required = false) String fail) {
        map.addAttribute("title", "Login: AD Credentials");
        if (fail != null) {
            map.addAttribute("error", "Invalid credentials");
        }
        return "login";
    }

    @RequestMapping(value = "/secure", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public String secure(ModelMap map, Principal principal) {
        System.out.println(principal.getName());
        return "secure";
    }
}