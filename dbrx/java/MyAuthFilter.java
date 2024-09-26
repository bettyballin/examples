import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component("MyAuthFilter")
public class MyAuthFilter extends UsernamePasswordAuthenticationFilter {

    private final LoginFailureHandler failureHandler;

    @Autowired
    public MyAuthFilter(LoginFailureHandler failureHandler) {
        this.failureHandler = failureHandler;
        super.setAuthenticationFailureHandler(failureHandler);
    }

    // ... other code ...
}

// Add this class to handle login failures
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        // Handle the failure
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication Failed");
    }
}