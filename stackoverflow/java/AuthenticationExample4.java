import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

public class AuthenticationExample4 {
    private DaoAuthenticationProvider daoAuthenticationProvider; // Assume this is provided
    
    public void authenticateAndRedirect(String userName, String password) {
        Authentication auth = new UsernamePasswordAuthenticationToken(userName, password);
        Authentication authenticated = daoAuthenticationProvider.authenticate(auth);
        SecurityContextHolder.getContext().setAuthentication(authenticated);
        
        // redirect to main application
        // Assuming getPage().setLocation("/main"); is valid in your context
        getPage().setLocation("/main");
    }
    
    // Assuming getPage() is a method in your context
    private YourPageType getPage() {
        // Implement this method to return the current page
        return null;
    }
}