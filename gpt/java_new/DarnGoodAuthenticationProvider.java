import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;

@Component("darnGoodAuthenticationProvider")
public class DarnGoodAuthenticationProvider implements AuthenticationUserDetailsService<Authentication> {

    @Override
    public UserDetails loadUserDetails(Authentication token) throws UsernameNotFoundException {
        // You should provide an actual implementation to load a user
        throw new UsernameNotFoundException("User not found");
    }
}