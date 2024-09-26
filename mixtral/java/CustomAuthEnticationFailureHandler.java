import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernameNotFoundException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        super.onAuthenticationFailure(request, response, exception);

        if (exception instanceof BadCredentialsException || exception instanceof UsernameNotFoundException) {
            applicationEventPublisher.publishEvent(new AuthenticationFailureBadCredentialsEvent(
                    request,
                    "Invalid credentials",
                    AuthenticationFailureReason.INVALID_CREDENTIALS));
        }
    }
}

// Additional classes to make the code executable
class AuthenticationFailureBadCredentialsEvent {
    private HttpServletRequest request;
    private String message;
    private AuthenticationFailureReason reason;

    public AuthenticationFailureBadCredentialsEvent(HttpServletRequest request, String message, AuthenticationFailureReason reason) {
        this.request = request;
        this.message = message;
        this.reason = reason;
    }

    // getters and setters
}

enum AuthenticationFailureReason {
    INVALID_CREDENTIALS
}