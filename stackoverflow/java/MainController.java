import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.access.annotation.Secured;

@Controller
public class MainController extends BaseController {

    @Secured("ROLE_ADMIN")
    @RequestMapping("/")
    public String home(Model model) {
        return "home";
    }
}