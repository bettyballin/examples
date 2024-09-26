import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Temp3679Application {
    public static void main(String[] args) {
        SpringApplication.run(Temp3679Application.class, args);
    }
}

@RestController
@RequestMapping("/auth")
class AuthController {

    @GetMapping("/test")
    public String test() {
        return "Authentication endpoint is working!";
    }
}