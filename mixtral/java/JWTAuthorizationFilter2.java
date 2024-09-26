import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {

        try {
            SecurityContextHolder.getContext()
                .setAuthentication(new UsernamePasswordAuthenticationToken("John Doe",
                    null,
                    List.of(new SimpleGrantedAuthority("MY_USER"))));

            // Call the next filter in the chain
            chain.doFilter(request, response);
        } catch (Exception e) {
            SecurityContextHolder.clearContext();
            throw new RuntimeException("Authentication failed", e);
        }
    }

    public static void main(String[] args) {
        // Main method for testing or running the application
    }
}