import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class Temp425 {
    public static void main(String[] args) {
        SpringApplication.run(Temp425.class, args);
    }
}

@RestController
class LoginController {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserInfo userInfo) {
        // Your authentication logic here
        return ResponseEntity.ok("Login successful");
    }
}

class UserInfo {
    private String username;
    private String password;

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}