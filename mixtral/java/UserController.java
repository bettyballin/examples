import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public String createUser() {
        return "User created successfully";
    }
}