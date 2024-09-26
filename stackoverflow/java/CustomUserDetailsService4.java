import org.springframework.security.core.userdetails.UserDetailsService;

public class CustomUserDetailsService4 implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Your custom logic to fetch user details from the database or another service
        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}