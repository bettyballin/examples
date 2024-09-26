import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;

public class CustomSessionAuthenticationStrategy extends ConcurrentSessionControlAuthenticationStrategy {

    public CustomSessionAuthenticationStrategy(SessionRegistry sessionRegistry) {
        super(sessionRegistry);
    }

    @Override
    public void onAuthentication(Authentication authentication, HttpServletRequest request, HttpServletResponse response) {
        if (!isSpecialUser(authentication)) {
            super.onAuthentication(authentication, request, response);
        }
    }
    
    private boolean isSpecialUser(Authentication authentication) {
        // Assuming there's an implementation that checks if the user is special
        User user = (User) authentication.getPrincipal();
        // Replace with the actual check
        return "special".equals(user.getUsername());
    }
}