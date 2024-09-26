import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Collection;
import java.util.Collections;

public class MyCustomUser extends YourCustomUserModel implements UserDetails {
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // or implement your custom logic
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // or implement your custom logic
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // or implement your custom logic
    }

    @Override
    public boolean isEnabled() {
        return true; // or implement your custom logic
    }
}