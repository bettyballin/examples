import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import javax.servlet.ServletException;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class PostLoginActionFilter extends OncePerRequestFilter {

    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)) {
            String userId = ((AuthorityUser) authentication.getPrincipal()).getUserId();
            User user = userService.getById(userId);

            if ((user.getChangeRequiredDob() || user.getChangeRequiredPwd() || user.getChangeRequiredTou())
                    && !isActionRequiredPage(request)) {
                response.sendRedirect("/action-required");
                return;
            }
        }

        filterChain.doFilter(request, response);
    }

    private boolean isActionRequiredPage(HttpServletRequest request) {
        // Logic to determine if the current page is the action required page
        // Placeholder for actual implementation
        return request.getRequestURI().equals("/action-required");
    }
}