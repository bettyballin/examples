import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Temp2493 {

    private final AuthenticationManager authenticationManager;

    public Temp2493(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public static void main(String[] args) {
        // Spring Boot application entry point
        org.springframework.boot.SpringApplication.run(Temp2493.class, args);
    }

    @PostMapping("/validateLogin")
    public ResponseEntity<String> validateLogin(@RequestBody Map<String, String> user) {
        try {
            Authentication auth = new UsernamePasswordAuthenticationToken(
                    user.get("email"),
                    user.get("password")
            );

            Authentication authenticated = authenticationManager.authenticate(auth);
            SecurityContextHolder.getContext().setAuthentication(authenticated);

            return ResponseEntity.ok("Login successful");
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Login failed");
        }
    }
}


Make sure to include the necessary `spring-boot-starter-security` and `spring-boot-starter-web` dependencies in your `pom.xml` file for this code to work properly.