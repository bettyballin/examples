import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

public class Temp126 {

    public static void main(String[] args) {
        // This is just a placeholder for the main method.
    }

    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String emailToken = request.getParameter("email_token");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Create a new authentication token
        UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(username, password);

        // Set the additional details on the custom Auth Token
        authReq.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        // Add your email_token to Authentication object
        Map<String, String> parameters = new HashMap<>();
        parameters.put("emailToken", emailToken);

        authReq.setDetails(parameters);

        return this.getAuthenticationManager().authenticate(authReq);
    }

    // Placeholder for getAuthenticationManager() method.
    // In a real application, this would return the AuthenticationManager instance.
    private AuthenticationManager getAuthenticationManager() {
        return new AuthenticationManager();
    }

    // Placeholder for AuthenticationManager class.
    // In a real application, this class would be provided by the Spring Security framework.
    private class AuthenticationManager {
        public Authentication authenticate(UsernamePasswordAuthenticationToken authReq) {
            // Authentication logic here.
            return authReq;
        }
    }
}