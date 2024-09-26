import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class UserDetailsImpl implements UserDetails {

    private Collection<GrantedAuthority> authorities = new ArrayList<>();

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        // Implement method to return user's password
        return null;
    }

    @Override
    public String getUsername() {
        // Implement method to return user's username
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        // Implement method to indicate if the account is non-expired
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Implement method to indicate if the account is non-locked
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Implement method to indicate if the credentials are non-expired
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Implement method to indicate if the account is enabled
        return true;
    }
}