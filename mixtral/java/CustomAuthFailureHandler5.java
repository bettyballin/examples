import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthFailureHandler implements AuthenticationFailureHandler {
    private AttemptService attemptService;

    public CustomAuthFailureHandler(AttemptService attemptService) {
        this.attemptService = attemptService;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        String username = ((UsernamePasswordAuthenticationToken)
                (exception.getAuthentication())).getName();

        attemptService.saveFailedAttempt(username);

        response.sendRedirect("/login?error=true");
    }
}

class AttemptService {
    public void saveFailedAttempt(String username) {
        // Implement the logic to save the failed attempt
        System.out.println("Failed attempt for user: " + username);
    }
}