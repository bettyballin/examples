import org.springframework.security.core.userdetails.UserDetailsService;

public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Your custom logic to fetch user details goes here
        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}