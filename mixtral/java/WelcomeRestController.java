import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class WelcomeApp {
    public static void main(String[] args) {
        SpringApplication.run(WelcomeApp.class, args);
    }
}

@Controller
class WelcomeRestController {

    @RequestMapping("/")
    public String welcome() {
        return "index";
    }
}