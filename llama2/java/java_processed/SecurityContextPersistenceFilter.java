import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SecurityContextPersistenceFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Store the original request URL in the security context
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setOriginalRequestUrl(request.getRequestURL().toString());
        SecurityContextHolder.setContext(context);

        try {
            // Continue the chain
            filterChain.doFilter(request, response);
        } finally {
            // Clear the security context
            SecurityContextHolder.clearContext();
        }
    }
}