import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final AttemptService attemptService;

    @Autowired
    public CustomUserDetailService(AttemptService attemptService) {
        this.attemptService = attemptService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Add your logic to load a user by username here
        // For example: return userRepository.findByUsername(username);
        throw new UsernameNotFoundException("User not found");
    }
}

interface AttemptService {
    // Define your methods here
}