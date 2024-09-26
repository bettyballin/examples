import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginStageOneController {

    @RequestMapping("/login/stage-one")
    public String showLoginForm(Model model, RedirectAttributes attributes) {
        // ...

        return "redirect:/login";
    }

}