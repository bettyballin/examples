import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class Temp947 implements AuthenticationFailureHandler {

    public static void main(String[] args) {
        // This main method is just a placeholder; 
        // the actual implementation would be used in a Spring Security context.
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        response.setContentType("application/json");
        String errorMessage = exception.getMessage(); // You can customize this message as needed
        response.getWriter().write("{\"error\": \"" + errorMessage + "\"}");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }
}