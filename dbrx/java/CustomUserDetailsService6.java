import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("customUserService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private YourWebServiceClient yourWebServiceClient;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException {
        // Call the SOAP WS and return back the user's roles.
        List<String> roles = yourWebServiceClient.getRolesForUsername(username);

        if (roles == null || roles.isEmpty()) {
            throw new UsernameNotFoundException("Invalid username/password");
        }

        User user = new User();
        user.setUsername(username);
        user.setAuthorities(roles.stream()
                .map(role -> new SimpleGrantedAuthority(role))
                .collect(Collectors.toList()));
        // Set other properties of 'user' object
        return user;
    }
}

// Dummy YourWebServiceClient class for demonstration purposes
class YourWebServiceClient {
    public List<String> getRolesForUsername(String username) {
        // Mock implementation
        return List.of("ROLE_USER");
    }
}

// Dummy User class for demonstration purposes
class User implements UserDetails {
    private String username;
    private List<GrantedAuthority> authorities;
    private String password;

    @Override
    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
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
}