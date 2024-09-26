import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.naming.AuthenticationException;
import java.io.IOException;

@RestController
public class Temp3020 {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final Logger logger;

    public Temp3020(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, Logger logger) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.logger = logger;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginMembers loginMembers) throws AuthenticationException, IOException, ServletException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginMembers.getEmail(),
                        loginMembers.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        logger.info("You are log in successfully with token");
        return ResponseEntity.ok(new AuthTokenRequest(token));
    }

    public static void main(String[] args) {
        // Spring Boot Application entry point
        SpringApplication.run(Temp3020.class, args);
    }

}

class LoginMembers {
    private String email;
    private String password;

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

class AuthTokenRequest {
    private String token;

    public AuthTokenRequest(String token) {
        this.token = token;
    }

    // Getter
    public String getToken() {
        return token;
    }
}

class JwtTokenUtil {
    public String generateToken(Authentication authentication) {
        // Implement token generation logic
        return "dummyToken";
    }
}

interface Logger {
    void info(String message);
}