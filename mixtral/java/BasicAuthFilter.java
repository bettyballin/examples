import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.web.filter.OncePerRequestFilter;

public class BasicAuthFilter extends OncePerRequestFilter {

    private final ClientRequestFactory clientRequestFactory;

    public BasicAuthFilter(ClientRequestFactory clientRequestFactory) {
        this.clientRequestFactory = clientRequestFactory;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authorizationHeaderValue = request.getHeader("Authorization");

        if (authorizationHeaderValue != null && authorizationHeaderValue.startsWith("Basic")) {
            // Extract username and password from the Basic Auth header

            // Exchange them for an access token using ROPC grant type

            // Add this access token to Spring Security ContextHolder

        }

        filterChain.doFilter(request, response);
    }
}