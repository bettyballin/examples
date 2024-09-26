import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import javax.annotation.Nullable;
import java.security.Principal;

@SpringBootApplication
public class Temp2108Application {
    public static void main(String[] args) {
        SpringApplication.run(Temp2108Application.class, args);
    }
}

@RestController
class UserController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/me")
    public Mono<User> find(@Nullable @AuthenticationPrincipal final Principal principal) {
        if (principal == null || ((JwtAuthenticationToken) principal).isExpired()) {
            return Mono.error(() -> new ResponseStatusException(HttpStatus.FORBIDDEN));
        }

        String email = ((JwtAuthenticationToken) principal).getToken().getClaimAsString("email");

        // Replace the following line with the actual user retrieval logic
        return Mono.just(new User(email));
    }
}

class User {
    private String email;

    public User(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}