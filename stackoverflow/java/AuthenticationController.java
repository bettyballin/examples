import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

public class AuthenticationController {

    @RequestMapping("/automatic/login/test")
    public @ResponseBody String automaticLoginTest(HttpServletRequest request, UserDetailsManager userDetailsManager) {
        String username = "anyUserName@YourSite.com";
        boolean result = authenticateUserAndInitializeSessionByUsername(username, userDetailsManager, request);
        return Boolean.toString(result);
    }

    public boolean authenticateUserAndInitializeSessionByUsername(String username, UserDetailsManager userDetailsManager, HttpServletRequest request) {
        try {
            request.getSession(); // generate session if one doesn't exist
            UserDetails user = userDetailsManager.loadUserByUsername(username);
            Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}