import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;

public class CustomUserDetails3 implements UserDetails {

    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private String customValue;

    public CustomUserDetails3(String username, String password, Collection<? extends GrantedAuthority> authorities, String customValue) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.customValue = customValue;
    }

    public String getCustomValue() {
        return customValue;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
    // Setter for customValue if needed
}

public class CustomUserDetails3Service implements UserDetailsService {
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Your logic to load user from database and convert to CustomUserDetails3 goes here
        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}