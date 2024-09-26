import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        setDefaultFailureUrl("/login?error=true");

        if (exception instanceof BadCredentialsException) {
            request.getSession().setAttribute("error", "Username/Password entered is incorrect.");
        } else if (exception instanceof DisabledException) {
            request.getSession().setAttribute("error", "Your account has been disabled.");
        } else {
            request.getSession().setAttribute("error", "Unknown error occurred.");
        }

        super.onAuthenticationFailure(request, response, exception);
    }
}