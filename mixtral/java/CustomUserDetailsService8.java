import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired
    private YourRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return this.userRepo
                .findById(email).orElseThrow(() -> new UsernameNotFoundException("No such user: " + email));
    }
}

interface YourRepository {
    java.util.Optional<UserDetails> findById(String email);
}