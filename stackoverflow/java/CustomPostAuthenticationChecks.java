import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;
import java.util.Collection;

public class CustomPostAuthenticationChecks implements UserDetailsChecker {

    @Override
    public void check(UserDetails userDetails) {
        CustomUser customUser = (CustomUser) userDetails;
        Collection<GrantedAuthority> authorities = customUser.getAuthorities();

        if (customUser.needsEmailAuthentication()) {
            authorities.clear();
            authorities.add(new SimpleGrantedAuthority("ROLE_NEEDS_EMAIL_AUTH"));
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_AUTHORIZED_USER"));
        }
    }
}

class CustomUser extends org.springframework.security.core.userdetails.User {
    // Assuming this class exists with the required constructor and methods
    public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public boolean needsEmailAuthentication() {
        // Implement your custom logic
        return false;
    }
}