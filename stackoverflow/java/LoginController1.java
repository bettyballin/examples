import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.ServletException;
import java.io.IOException;

@RestController
public class LoginController1 {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final Logger logger = LoggerFactory.getLogger(LoginController1.class);

    public LoginController1(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginMembers loginMembers) throws AuthenticationException, IOException, ServletException {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginMembers.getEmail(),
                        loginMembers.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenUtil.generateToken(authentication);
        logger.info("You are logged in successfully with token");
        return ResponseEntity.ok(new AuthTokenRequest(token));
    }
}

class LoginMembers {
    private String email;
    private String password;

    // Getters and setters for email and password
}

class JwtTokenUtil {
    public String generateToken(Authentication authentication) {
        // Method implementation to generate token
        return "";
    }
}

class AuthTokenRequest {
    private String token;

    public AuthTokenRequest(String token) {
        this.token = token;
    }

    // Getter for token
}