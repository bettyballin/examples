import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Retrieve user details from .NET application and create a new instance of `CustomUserDetails`
        CustomUserDetails customUserDetails = fetchUserDetailsFromDotNetApplication(username);
        
        if (customUserDetails == null) {
            throw new UsernameNotFoundException("User not found");
        }
        
        return customUserDetails;
    }
    
    private CustomUserDetails fetchUserDetailsFromDotNetApplication(String username) {
        // Implement the logic to fetch user details from the .NET application
        // This is a placeholder implementation and should be replaced with actual code
        return new CustomUserDetails(username, "password", "ROLE_USER");
    }
}

class CustomUserDetails implements UserDetails {
    private String username;
    private String password;
    private String role;

    public CustomUserDetails(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(role));
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