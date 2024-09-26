import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.AuthenticationException;

public class AuthentiCatioNprovider extends AbstractUserDetailsAuthenticationProvider {

    @Override
    protected void additionalAuthenticationChecks(
            UserDetails user,
            Authentication authentication)
        throws AuthenticationException
    {

        if (authentication.getCredentials() == null ||
                !user.getPassword().equals("{noop}" +
                        ((UsernamePasswordAuthenticationToken)
                                authentication).getCredentials())) {
            throw new BadCredentialsException(
                    messages.getMessage(
                            "AbstractUserDetailsAuthenticationProvider.BAD_CREDENTIALS",
                            "Bad credentials"));
        }
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        // Implement this method with your own user retrieval logic
        return null;
    }
}