import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

public class CustomAuthenticationProvider extends DaoAuthenticationProvider {

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        // Perform the checks from the super class
        super.additionalAuthenticationChecks(userDetails, authentication);

        // Cast the UserDetails to the implementation you use
        User user = (User) userDetails;

        // Check the confirmed status
        if (!user.isAccountNonLocked()) {
            throw new AccountNotConfirmedException("Account is not confirmed yet.");
        }
    }

    public static class AccountNotConfirmedException extends AuthenticationException {
        public AccountNotConfirmedException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        // Please note that this main method is just for demonstration
        // and won't actually execute properly without a full Spring context setup.
        CustomAuthenticationProvider provider = new CustomAuthenticationProvider();
        UserDetailsService userDetailsService = null; // Initialize with actual UserDetailsService
        provider.setUserDetailsService(userDetailsService);

        UserDetails userDetails = User.withUsername("user")
                                      .password("password")
                                      .roles("USER")
                                      .disabled(false)
                                      .accountLocked(false)
                                      .build();

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken("user", "password");

        try {
            provider.additionalAuthenticationChecks(userDetails, authenticationToken);
            System.out.println("Authentication successful");
        } catch (AuthenticationException e) {
            System.out.println(e.getMessage());
        }
    }
}