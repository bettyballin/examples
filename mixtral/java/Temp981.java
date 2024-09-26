import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsByNameServiceWrapper;
import org.springframework.security.provisioning.UserDetailsManager;

public class Temp981 {

    @Autowired
    private UserDetailsManager userManager;

    public AuthenticationProvider configureAuthenticationProvider(AuthenticationProvider authenticationProvider) {
        UserDetailsByNameServiceWrapper userDetailsWrapper = new UserDetailsByNameServiceWrapper(userManager);
        authenticationProvider.setPreAuthenticatedUserDetailsService(userDetailsWrapper);
        return authenticationProvider;
    }

    public static void main(String[] args) {
        // This main method is just a placeholder.
        // In a real Spring application, the configuration would be managed by the Spring framework.
    }
}