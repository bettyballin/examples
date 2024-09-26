import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class Temp377 {

    public static void main(String[] args) {
        // Spring Boot application would normally be started here.
        // However, @RequestMapping methods are not called directly in main.
        // They are handled by the Spring framework.
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model m, HttpSession session, Principal principal) {
        // principal.getName() returns username
        return "XYZ";
    }
}