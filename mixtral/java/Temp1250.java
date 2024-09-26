import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class Temp1250 {
    public static void main(String[] args) {
        SpringApplication.run(Temp1250.class, args);
    }

    @RestController
    @RequestMapping("/api")
    public static class MyController {

        @PreAuthorize("hasRole('ROLE_USER')")
        @GetMapping("/secure")
        public String secureEndpoint() {
            return "This is a secure endpoint!";
        }

        @GetMapping("/public")
        public String publicEndpoint() {
            return "This is a public endpoint!";
        }
    }
}