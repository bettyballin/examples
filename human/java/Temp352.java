import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.switchuser.SwitchUserFilter;
import org.springframework.security.core.AuthenticationException;

public class Temp352 extends SwitchUserFilter {
    public static void main(String[] args) {
        // This part is just to make it executable, it doesn't actually test the method.
        System.out.println("Temp352 class loaded.");
    }

    @Override
    protected Authentication attemptSwitchUser(HttpServletRequest request) throws AuthenticationException {
        Authentication switchTo = super.attemptSwitchUser(request);
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        // Inspect currentUser (e.g. authorities) and switchTo to see if valid combination
        // Raise AuthenticationException if not

        return switchTo;
    }
}