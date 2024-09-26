import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        String errorMessage = "Invalid username or password";
        if (exception instanceof BadCredentialsException) {
            errorMessage = "Bad credentials";
        }

        // Redirect to login page with error message in session attribute
        HttpSession session = request.getSession();
        session.setAttribute("SPRING_SECURITY_LAST_EXCEPTION", exception.getMessage());
        response.sendRedirect(request.getContextPath() + "/login?error=" + errorMessage);
    }
}