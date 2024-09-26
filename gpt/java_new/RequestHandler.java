import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class RequestHandler {
    
    public void handleRequest(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Basic ")) {
            // Extract encoded username and password
            String base64Credentials = authHeader.substring("Basic ".length()).trim();
            byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(credDecoded, StandardCharsets.UTF_8);
            
            // Split into username and password
            final String[] values = credentials.split(":", 2);
            String username = values[0];
            String password = values[1];
            
            // Handle username and password
            // ...
        }
        
        // Continue handling the request
        // ...
    }
}