import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.stereotype.Component;

@Component
public class MyDatabaseAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private MyUserDetailsContextMapper userDetailsContextMapper;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, Authentication authentication) throws AuthenticationException {
        // Custom logic for additional authentication checks
    }

    @Override
    protected UserDetails retrieveUser(String username, Authentication authentication) throws AuthenticationException {
        UserDetails userDetails;
        try {
            userDetails = userDetailsContextMapper.loadUserByUsername(username);
        } catch (UsernameNotFoundException notFound) {
            throw new UsernameNotFoundException("User not found", notFound);
        }
        return userDetails;
    }
}