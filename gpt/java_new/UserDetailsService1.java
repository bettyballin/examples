import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class UserDetailsService1 {

    public UserDetails loadUserByUsername(User user) {
        boolean enabled = true; // Assuming these should be determined somehow
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        return new org.springframework.security.core.userdetails.User(
            user.getUsername(),
            user.getPassword(), // Use the password as is
            enabled, accountNonExpired,
            credentialsNonExpired, accountNonLocked,
            getAuthorities(Arrays.asList("ROLE_USER")));
    }

    private Collection<SimpleGrantedAuthority> getAuthorities(Collection<String> roles) {
        return roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
    
    // Assuming User class exists with getUsername() and getPassword() methods
    class User {
        String getUsername() {
            // implementation here
            return "";
        }
        
        String getPassword() {
            // implementation here
            return "";
        }
    }
}