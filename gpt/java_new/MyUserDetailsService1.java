import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class MyUserDetailsService1 implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Your custom logic to fetch user details from the database or another source
        // For demonstration, we'll create a dummy user with a username "user" and password "password"
        // with a single role "ROLE_USER"

        if (!username.equals("user")) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        // Replace with your own UserDetails implementation
        return new org.springframework.security.core.userdetails.User(username, "password", authorities);
    }
}