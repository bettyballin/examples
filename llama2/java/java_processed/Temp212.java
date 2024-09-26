import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class Temp212 {
    public static void main(String[] args) {
        // Sample data for user
        String login = "user";
        String password = "password";
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        
        // Sample authorities
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        
        // Creating a new User object
        User user = new User(login, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        
        // Output to verify user creation
        System.out.println("User created: " + user.getUsername());
    }
}