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
import java.io.IOException;

@RestController
public class AuthenticationController2 {

    private static final int MAX_ATTEMPTS = 3;
    private final AuthenticationManager authenticationManager;
    private final MembersDao membersDao;
    private final JwtTokenUtil jwtTokenUtil;

    public AuthenticationController2(AuthenticationManager authenticationManager, MembersDao membersDao, JwtTokenUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.membersDao = membersDao;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginMembers loginMembers) throws AuthenticationException, IOException, ServletException {
        Members members = membersDao.findByEmail(loginMembers.getEmail());
        PasswordEncoder passencoder = new BCryptPasswordEncoder();

        if (members == null) {
            throw new RuntimeException("Invalid Username and Password");
        }
        if (members.getAttempts() >= MAX_ATTEMPTS) {
            throw new RuntimeException("Login Attempt exceeds " + MAX_ATTEMPTS);
        }

        if (passencoder.matches(loginMembers.getPassword(), members.getPassword())) {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginMembers.getEmail(),
                            loginMembers.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtTokenUtil.generateToken(authentication);
            return ResponseEntity.ok(new AuthTokenRequest(token));
        } else {
            int attempts = members.getAttempts();
            members.setAttempts(++attempts);
            membersDao.save(members);
            throw new RuntimeException("Login attempts " + attempts);
        }
    }
}