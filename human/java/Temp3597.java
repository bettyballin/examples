import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Temp3597Application {
    public static void main(String[] args) {
        SpringApplication.run(Temp3597Application.class, args);
    }
}

@RestController
class Temp3597Controller {
    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(Authentication authentication) {
        return ResponseEntity.ok("Welcome [" + authentication.getName() + "]");
    }

    @GetMapping("/loginFailed")
    public ResponseEntity<String> login() {
        return ResponseEntity.ok("Failed to login");
    }
}