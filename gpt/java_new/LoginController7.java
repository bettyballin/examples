import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import java.io.IOException;

@Controller
public class LoginController7 {
    @RequestMapping("/notconfirmed")
    public String notConfirmed() {
        // Your logic for handling not confirmed case
        return "notconfirmed"; // Assuming "notconfirmed" is the view name
    }
}

class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        if (exception instanceof DisabledException) {
            response.sendRedirect("/notconfirmed");
        } else {
            // Your existing error message handling logic
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication Failed: " + exception.getMessage());
        }
    }
}