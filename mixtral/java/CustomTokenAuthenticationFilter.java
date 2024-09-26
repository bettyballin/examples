import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.web.filter.OncePerRequestFilter;

public class CustomTokenAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // Custom authentication logic here

        // Continue the filter chain
        filterChain.doFilter(request, response);
    }

    public static void main(String[] args) {
        System.out.println("CustomTokenAuthenticationFilter is ready to be used.");
    }
}