import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class Temp1275 {
    public static void main(String[] args) {
        SpringApplication.run(Temp1275.class, args);
    }
}

@Controller
class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("name", user.getUsername());
        return "greeting";
    }
}