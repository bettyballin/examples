import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Temp1156 {
    public static void main(String[] args) {
        // Example usage of the commence method
        HttpServletRequest request = null; // This should be an actual request object
        HttpServletResponse response = null; // This should be an actual response object
        AuthenticationException authException = new AuthenticationException("Authentication failed!");

        try {
            commence(request, response, authException);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        // Implementation of the commence method
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
    }
}

class AuthenticationException extends Exception {
    public AuthenticationException(String message) {
        super(message);
    }
}