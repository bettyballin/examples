import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;

public class User implements UserDetails {
    // Other methods and fields

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new HashSet<GrantedAuthority>();
    }

    @Override
    public String getPassword() {
        // Implement this method
        return null;
    }

    @Override
    public String getUsername() {
        // Implement this method
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        // Implement this method
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Implement this method
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Implement this method
        return false;
    }

    @Override
    public boolean isEnabled() {
        // Implement this method
        return false;
    }
}