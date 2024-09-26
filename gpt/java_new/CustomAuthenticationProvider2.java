import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomAuthenticationProvider2 extends DaoAuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UserDetails loadedUser = this.getUserDetailsService().loadUserByUsername(authentication.getName());
        if (!checkAdditionalUserDetails(loadedUser)) {
            throw new AuthenticationException("Additional user details check failed") {};
        }
        return super.authenticate(authentication);
    }

    private boolean checkAdditionalUserDetails(UserDetails user) {
        // Implement your additional checks here
        return true;
    }
}