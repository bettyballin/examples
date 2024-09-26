import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService20 implements UserDetailsService {

    // Inject your external database repository or service here
    // @Autowired
    // private YourUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch the user from the external database
        // YourUserEntity userEntity = userRepository.findByUsername(username)
        //     .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Assuming the user has been fetched successfully, and has a password field
        // String password = userEntity.getPassword();

        // For the sake of compilation, we will use a dummy password
        String password = "dummyPassword";

        // Convert the entity to UserDetails
        return User.withUsername(username)
                .password(password)
                .authorities("ROLE_USER") // Assuming the user has a role of "ROLE_USER"
                .build();
    }
}