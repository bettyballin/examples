import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
public class TosFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        System.out.println(request.getRequestURI());

        // Assuming HelloWorldController.acceptedTOS is accessible here
        if (!HelloWorldController.acceptedTOS) {
            request.getRequestDispatcher("/error-no-tos").forward(request, response);
        } else {
            filterChain.doFilter(request, response);
        }
    }

    // Placeholder for HelloWorldController with the static acceptedTOS variable
    // In a real-world scenario, this would be replaced with an appropriate service or mechanism to check TOS acceptance.
    public static class HelloWorldController {
        public static boolean acceptedTOS = false; // Example default value; in reality, this would be queried from a database or other storage.
    }
}