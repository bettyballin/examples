import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableResourceServer
@EnableWebSecurity
public class Temp389 {
    public static void main(String[] args) {
        SpringApplication.run(Temp389.class, args);
    }
}

@RestController
@RequestMapping("/api")
class UserController {

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('SCOPE_user')")
    public ResponseEntity<User> getUser() {
        User user = new User(); 
        return ResponseEntity.ok(user);
    }
}

class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}