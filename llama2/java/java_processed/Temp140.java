import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Temp140 {
    public static void main(String[] args) {
        SpringApplication.run(Temp140.class, args);
    }
}

@Controller
class SecureController {

    @Secured("ROLE_USER")
    @RequestMapping("/secure/login")
    public String login() {
        return "login";
    }
}