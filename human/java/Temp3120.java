import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Temp3120 {
    public static void main(String[] args) {
        SpringApplication.run(Temp3120.class, args);
    }
}

@RestController
@RequestMapping("/api")
class MyController {

    @PostMapping("/authenticateMe")
    public String login() {
        return "start";
    }
}