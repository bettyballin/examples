import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class MyUserDetailsService1 implements UserDetailsService {

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {   
       // Assuming these variables are properly initialized within the method
       String password = "..."; // Replace with actual password retrieval logic
       boolean enabled = true; // Replace with actual enabled status retrieval logic
       boolean accountNonExpired = true; // Replace with actual accountNonExpired status
       boolean credentialsNonExpired = true; // Replace with actual credentialsNonExpired status
       boolean accountNonLocked = true; // Replace with actual accountNonLocked status
       Collection<? extends GrantedAuthority> authorities = new ArrayList<>(); // Replace with actual authorities retrieval logic

       UserDetails user = new User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
       return user;
    }   
}