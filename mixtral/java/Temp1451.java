import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Temp1451Application {
    public static void main(String[] args) {
        SpringApplication.run(Temp1451Application.class, args);
    }
}

@RestController
class UserController {

    @GetMapping("/user")
    public ResponseEntity<CustomUser> getCurrentLoggedInUser(@AuthenticationPrincipal CustomUser customUser) {
        return new ResponseEntity<>(customUser, HttpStatus.OK);
    }
}

class CustomUser {
    private String username;
    private String email;

    // getters and setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}