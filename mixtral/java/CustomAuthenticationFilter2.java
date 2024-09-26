import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String username = request.getParameter("user");
        String password = request.getParameter("pass");

        if (username != null && password != null) {
            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);

            try {
                // Perform your custom validation here

                SecurityContextHolder.getContext().setAuthentication(authRequest);

                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

                if (authentication == null) {
                    throw new Exception("No authenticated user");
                }

                filterChain.doFilter(request, response);
            } catch (Exception e) {
                // Handle exceptions here
                SecurityContextHolder.clearContext();
                request.getSession().invalidate();

                RequestDispatcher dispatcher = request.getRequestDispatcher("/login?error");
                if (dispatcher != null) {
                    dispatcher.forward(request, response);
                }
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }
}