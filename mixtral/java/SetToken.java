import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SetToken extends OncePerRequestFilter {

    private boolean isExecuted = false;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (!isExecuted && SecurityContextHolder.getContext().getAuthentication() != null
                && SecurityContextHolder.getContext().getAuthentication().getName() != null
                && !SecurityContextHolder.getContext().getAuthentication().getName().isEmpty()) {
            // Get principal and make an API call to a third-party system to set the cookie

            Cookie customCookie = new Cookie("token", "value"); // Example cookie creation
            response.addCookie(customCookie);

            isExecuted = true;
        }

        filterChain.doFilter(request, response);
    }
}