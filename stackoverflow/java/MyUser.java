import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class MyUser implements UserDetails {

    private static final long serialVersionUID = 1L;

    // Define user properties here

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Return the authorities
        return null;
    }

    @Override
    public String getPassword() {
        // Return the user's password
        return null;
    }

    @Override
    public String getUsername() {
        // Return the user's username
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        // Return whether the user's account is non-expired
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Return whether the user's account is non-locked
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Return whether the user's credentials are non-expired
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Return whether the user is enabled
        return true;
    }

    // Implement getters and setters for your user properties here

}