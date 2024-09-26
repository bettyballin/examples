import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService1 implements UserDetailsService {
    // Inject repositories or JdbcTemplate to access user data
    // Example using UserRepository
    private final UserRepository userRepository;

    public CustomUserDetailsService1(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Implement the required method from UserDetailsService
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Your implementation goes here, fetching user from the database
        // and convert it to UserDetails object and return it
        return null; // Placeholder return, replace with actual user data
    }
}