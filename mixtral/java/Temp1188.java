import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Temp1188 {
    
    @Autowired
    private PersistentTokenBasedRememberMeServices rememberMeService;

    public void register(HttpServletRequest request, HttpServletResponse response, String user, String password) throws Exception {
        // Assuming principal, credentials, and authorities are defined elsewhere in your code
        Object principal = user; // Example: user object
        Object credentials = password; // Example: password
        Object authorities = null; // Example: authorities list

        // Login the user
        request.login(user, password);

        // Create and set Remember-me cookie
        Authentication auth = new UsernamePasswordAuthenticationToken(principal, credentials, null);

        rememberMeService.onLoginSuccess(request, response, auth);
    }

    public static void main(String[] args) {
        // Example usage
        // This is just a placeholder. Actual implementation will depend on your Spring context setup
    }
}