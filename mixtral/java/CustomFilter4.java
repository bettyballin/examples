import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedException;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomFilter extends OncePerRequestFilter {

    @Autowired
    private UserRepository userRepo;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        if (username != null && !userRepo.findByUsername(username).isEmpty()) {
            User user = userRepo.findByUsername(username);

            // Check the special property
            boolean hasSpecialProperty = user.getLogin() != null
                    ? user.getLogin().endsWith("_login")
                    : false;

            if (!hasSpecialProperty) {
                throw new AccessDeniedException("User does not have a valid login");
            }
        }

        filterChain.doFilter(request, response);
    }
}