import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

public class AuthenticationExample {

    private String userName;
    private String password;
    private DaoAuthenticationProvider daoAuthenticationProvider;

    public AuthenticationExample(String userName, String password, DaoAuthenticationProvider daoAuthenticationProvider) {
        this.userName = userName;
        this.password = password;
        this.daoAuthenticationProvider = daoAuthenticationProvider;
    }

    public void authenticateAndRedirect() {
        Authentication auth = new UsernamePasswordAuthenticationToken(userName, password);
        Authentication authenticated = daoAuthenticationProvider.authenticate(auth);
        SecurityContextHolder.getContext().setAuthentication(authenticated);

        // redirect to main application
        // Assuming getPage() is a method that returns a Page object
        getPage().setLocation("/main");
    }

    // Mock method for getPage(). Adjust according to your actual implementation.
    private Page getPage() {
        return new Page();
    }

    // Mock Page class. Adjust according to your actual implementation.
    class Page {
        public void setLocation(String location) {
            System.out.println("Redirecting to: " + location);
        }
    }

    public static void main(String[] args) {
        // Example usage
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        // Configure daoAuthenticationProvider as necessary

        AuthenticationExample example = new AuthenticationExample("user", "password", daoAuthenticationProvider);
        example.authenticateAndRedirect();
    }
}