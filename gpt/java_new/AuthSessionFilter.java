import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.List;

public class AuthSessionFilter extends OncePerRequestFilter {

    private final List<String> permittedUris;

    public AuthSessionFilter(List<String> permittedUris) {
        this.permittedUris = permittedUris;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getRequestURI();
        boolean isPermittedUri = permittedUris.stream().anyMatch(path::equals);

        if (isPermittedUri) {
            filterChain.doFilter(request, response);
        } else {
            // Handle unauthorized access or redirect to login
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}