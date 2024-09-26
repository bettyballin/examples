import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Temp453 {
    public static void main(String[] args) {
        // Spring Boot would typically run the application
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLogin(Model model) {
        LoginForm form = new LoginForm();
        model.addAttribute("form", form);
        return new ModelAndView("login");
    }
}

class LoginForm {
    // Define fields, getters, and setters for the form
}