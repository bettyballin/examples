import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Temp431 {
    public static void main(String[] args) {
        SpringApplication.run(Temp431.class, args);
    }
}

@RestController
class HomeController {
    @GetMapping("/")
    @Secured("ROLE_USER")
    public String home() {
        return "home";
    }
}