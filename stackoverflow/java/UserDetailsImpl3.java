import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Collection;
import java.util.Collections;

public class UserDetailsImpl3 { // Assuming this is within a class that implements UserDetails

    private User user; // Assuming there is a User class with a getRole method

    // ... other methods and fields ...

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(user.getRole()));
    }

    // ... other methods and fields ...
}