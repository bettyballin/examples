import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Temp3196Application {
    public static void main(String[] args) {
        SpringApplication.run(Temp3196Application.class, args);
    }
}

@RestController
class Temp3196Controller {

    @GetMapping("/authentication")
    public String testAuthentication(Authentication authentication) {
        UserDetailsStub userDetailsStub = UserDetailsStub.of((User) authentication.getPrincipal());
        return userDetailsStub.getUsername();
    }
}

class UserDetailsStub {
    private String username;

    public UserDetailsStub(String username) {
        this.username = username;
    }

    public static UserDetailsStub of(User user) {
        return new UserDetailsStub(user.getUsername());
    }

    public String getUsername() {
        return username;
    }
}