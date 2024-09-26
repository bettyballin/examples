import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @GetMapping("/registration")
    public String showRegistrationForm(Model model, @javax.servlet.annotation.WebServlet HttpSession session) {
        // Retrieve the saved failedUsername from session and add it to the Model.
        Object failedUsernameObj = session.getAttribute("failedUsername");
        if (failedUsernameObj != null && !((String) failedUsernameObj).isEmpty()) {
            model.addAttribute("preFilledUsername", failedUsernameObj);
        }
        return "registration";
    }
}