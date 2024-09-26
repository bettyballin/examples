import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Temp430 {
    public static void main(String[] args) {
        SpringApplication.run(Temp430.class, args);
    }

    @RestController
    public static class HomeController {
        @GetMapping("/")
        public String home() {
            return "home";
        }
    }
}