import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class CustomAuthenticationFilter5 extends UsernamePasswordAuthenticationFilter {
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        // Retrieve the IP address from the request
        String ipAddress = request.getRemoteAddr();

        // Check if the IP address is authorized
        boolean isAuthorizedIP = checkIPAddress(ipAddress);
        if (!isAuthorizedIP) {
            throw new RuntimeException("Unauthorized IP address");
        }

        // Continue with the authentication process
        return super.attemptAuthentication(request, response);
    }

    private boolean checkIPAddress(String ipAddress) {
        // Implement your IP checking logic here
        // For example, allow any IP address:
        return true;
    }
}