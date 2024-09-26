import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController5 {
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}