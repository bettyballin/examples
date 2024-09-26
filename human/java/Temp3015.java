import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.security.sasl.AuthenticationException;
import java.io.IOException;

@RestController
public class Temp3015 {

    @Autowired
    private MembersDao membersDao;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private Logger logger;

    private static final int MAX_ATTEMPTS = 3;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginMembers loginMembers) throws AuthenticationException, IOException, ServletException {
        Members members = membersDao.findByEmail(loginMembers.getEmail());
        PasswordEncoder passencoder = new BCryptPasswordEncoder();

        if (members == null) {
            //Create Error Message for User
            throw new RuntimeException("Invalid Username and Password");
        }
        if (members.getAttempts() >= MAX_ATTEMPTS) {
            //Create Error Message for User
            throw new RuntimeException("Login Attempt exceeds " + MAX_ATTEMPTS);
        }

        if (passencoder.matches(loginMembers.getPassword(), members.getPassword())) {
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
        } else {
            int attempts = members.getAttempts();
            members.setAttempts(++attempts);
            membersDao.save(members);
            //Create Error Message for User
            throw new RuntimeException("Login attempts " + attempts);
        }
    }
}

class Members {
    private String email;
    private String password;
    private int attempts;

    // Getters and setters
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

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }
}

class LoginMembers {
    private String email;
    private String password;

    // Getters and setters
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

    // Getters and setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

interface MembersDao {
    Members findByEmail(String email);
    void save(Members members);
}

interface JwtTokenUtil {
    String generateToken(Authentication authentication);
}

interface Logger {
    void info(String message);
}