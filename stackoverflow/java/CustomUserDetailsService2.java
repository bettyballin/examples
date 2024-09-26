import org.springframework.security.core.userdetails.UserDetailsService;

public class CustomUserDetailsService2 implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Your custom logic to fetch user details from the database or any other source
        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}