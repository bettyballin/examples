import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class User implements UserDetails {
    private String role;

    public User(String role) {
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(this.role));
        return authorities;
    }

    @Override
    public String getPassword() {
        // Implement your logic to return user's password
        return null;
    }

    @Override
    public String getUsername() {
        // Implement your logic to return user's username
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        // Implement your logic to determine if the account is non-expired
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Implement your logic to determine if the account is non-locked
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Implement your logic to determine if the credentials are non-expired
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Implement your logic to determine if the account is enabled
        return true;
    }
}