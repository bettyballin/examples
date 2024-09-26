import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) 
            throws ServletException, IOException {
        // Extract the Firebase token from header
        String firebaseToken = request.getHeader("Firebase-token");

        if (firebaseToken != null && !request.getRequestURI().equals("/registerUser")) {
            try {
                boolean isValid = validateFirebaseToken(firebaseToken);

                // If token validation fails send an error response
                if (!isValid) {
                    throw new AuthenticationException("Invalid Firebase Token");
                }
            } catch (AuthenticationException e) {
                // Handle the exception
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
                return;
            }
        }

        filterChain.doFilter(request, response);
    }

    private boolean validateFirebaseToken(String firebaseToken) {
        // Implement your Firebase token validation logic here
        return true;
    }

    private static class AuthenticationException extends Exception {
        public AuthenticationException(String message) {
            super(message);
        }
    }
}