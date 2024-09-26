import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.http.HttpHeaders;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Temp3580 {

    private JwtUtils jwtUtils;
    private UserService userService;

    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        var header = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (header == null || !header.startsWith(jwtUtils.Bearer)) {
            chain.doFilter(request, response);
            return;
        }

        var jwt = header.replace(jwtUtils.Bearer, "");
        var username = jwtUtils.extractUsername(jwt);

        if (username == null && SecurityContextHolder.getContext().getAuthentication() != null) {
            chain.doFilter(request, response);
            return;
        }

        var user = userService.loadUserByUsername(username);

        if (!jwtUtils.validateToken(jwt, user) || !user.isEnabled()) {
            chain.doFilter(request, response);
            return;
        }

        var passwordAuthToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        passwordAuthToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(passwordAuthToken);
        chain.doFilter(request, response);
    }

    public static void main(String[] args) {
        // This main method is just a placeholder and does not invoke the filter method.
        // In a real-world scenario, the filter method would be called by the Spring Security framework.
    }

    // Mock classes for JwtUtils and UserService for this example to compile
    private class JwtUtils {
        public final String Bearer = "Bearer ";

        public String extractUsername(String jwt) {
            // Mock implementation
            return "user";
        }

        public boolean validateToken(String jwt, Object user) {
            // Mock implementation
            return true;
        }
    }

    private class UserService {
        public User loadUserByUsername(String username) {
            // Mock implementation
            return new User();
        }
    }

    private class User {
        public boolean isEnabled() {
            // Mock implementation
            return true;
        }

        public Object getAuthorities() {
            // Mock implementation
            return null;
        }
    }
}