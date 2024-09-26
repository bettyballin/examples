import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.web.filter.OncePerRequestFilter;

public class JWTAuthenticationFilter extends OncePerRequestFilter {

    private JWTService jwtService; // Assuming you have a JWTService to validate tokens

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            // Your existing code here
            String jwt = extractJWTFromRequest(request); // Implement this method to extract JWT from request
            String userEmail = extractUserEmailFromJWT(jwt); // Implement this method to extract user email from JWT

            if (jwt == null || !jwtService.isTokenValid(userEmail, jwt)) {
                throw new CustomJWTException("To access this resource you must provide a valid security token", HttpStatus.UNAUTHORIZED);
            }

            // Rest of your code

        } catch (CustomJWTException ex) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
            return;
        }

        filterChain.doFilter(request, response);
    }

    private String extractJWTFromRequest(HttpServletRequest request) {
        // Implement this method to extract JWT from request
        return null;
    }

    private String extractUserEmailFromJWT(String jwt) {
        // Implement this method to extract user email from JWT
        return null;
    }
}

class CustomJWTException extends RuntimeException {
    private HttpStatus httpStatus;

    public CustomJWTException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}