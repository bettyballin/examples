import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Add required imports
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.DefaultRedirectStrategy;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        // Very simple (most probably broken) check if the user is ADMIN or USER
        boolean isUser = authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("USER"));
        
        if (isUser) {
            redirectStrategy.sendRedirect(request, response, "/profile.html");
        } else {
            redirectStrategy.sendRedirect(request, response, "/admin.html");
        }

        clearAuthenticationAttributes(request);
    }

    protected void clearAuthenticationAttributes(HttpServletRequest request) {
        // Method to clear authentication attributes
        // This is just a placeholder, actual implementation may vary
    }
}