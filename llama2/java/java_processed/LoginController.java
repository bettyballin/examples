import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "customer", required = false) String customer, Model model) {
        // Use the customer parameter to determine the appropriate tenant
        model.addAttribute("customer", customer);
        return "login";
    }

    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(LoginController.class, args);
    }
}