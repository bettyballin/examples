import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Secured("ROLE_ADMIN")
    @RequestMapping("/")
    String home(Model model) {
        return "home";
    }

}