import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;

@SpringBootApplication
public class Temp2870 {
    public static void main(String[] args) {
        SpringApplication.run(Temp2870.class, args);
    }
}

@RestController
class MyController {
    @GetMapping("/")
    public String get(@AuthenticationPrincipal User user) {
        if (user != null) {
            return "Hello, " + user.getUsername();
        } else {
            return "Hello, Guest";
        }
    }
}