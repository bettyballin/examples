import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.BadCredentialsException;

public class Temp36 {
    public static void main(String[] args) {
        // This is a placeholder. In a real scenario, you'd get this from the HttpServletRequest.
        HttpServletRequest httpServletRequest = null; 

        String authHeader = httpServletRequest.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Basic ")) {
            String base64Token = authHeader.substring(6);
            byte[] decoded;
            try {
                decoded = Base64.getDecoder().decode(base64Token);
            } catch (IllegalArgumentException e) {
                throw new BadCredentialsException("Failed to decode basic authentication token");
            }
            String token = new String(decoded, StandardCharsets.UTF_8);

            int delim = token.indexOf(':');
            if (delim == -1) {
                throw new BadCredentialsException("Invalid basic authentication token");
            }

            // Extract username and password if needed
            String username = token.substring(0, delim);
            String password = token.substring(delim + 1);

            // For demonstration purposes
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
        }
    }
}