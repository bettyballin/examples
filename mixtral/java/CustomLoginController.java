import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomLoginController {

    @RequestMapping("/custom_login")
    public String showCustomLoginPage() {
        return "custom_login"; // name of the JSP file
    }

    public static void main(String[] args) {
        SpringApplication.run(CustomLoginController.class, args);
    }
}