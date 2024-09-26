import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class Temp739 implements AuthenticationFailureHandler {
    public static void main(String[] args) {
        // The main method is not used in this context
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        String errorMessage = "Invalid username or password";

        if (exception.getMessage().contains("User is disabled")) {
            errorMessage = "This user account has been deactivated.";
        } else if (exception.getMessage().contains("User account expired")) {
            errorMessage = "The login for this user account has expired";
        }

        request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, exception);

        response.sendRedirect("/login?error=" + URLEncoder.encode(errorMessage, StandardCharsets.UTF_8.toString()));
    }
}