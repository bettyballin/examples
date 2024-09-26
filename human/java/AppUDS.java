import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class AppUDS implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException {
        // Mock user data for demonstration purposes
        if (!"user".equals(username)) {
            throw new UsernameNotFoundException("User not found");
        }
        
        // Create a list of authorities (roles)
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        
        // Create a UserDetails object with the username, password, and authorities
        return new User(username, "{noop}password", authorities); // {noop} is used to indicate no password encoding
    }
    
    public static void main(String[] args) {
        AppUDS appUDS = new AppUDS();
        try {
            UserDetails userDetails = appUDS.loadUserByUsername("user");
            System.out.println("Username: " + userDetails.getUsername());
            System.out.println("Authorities: " + userDetails.getAuthorities());
        } catch (UsernameNotFoundException | DataAccessException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}