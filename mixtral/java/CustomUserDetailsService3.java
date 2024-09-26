import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private YourRepository repository; // Replace with your actual repo

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<YourEntity> user = this.repository.findByEmail(username);

        if (user == null || !user.isPresent())
            throw new UsernameNotFoundException("Invalid email or password.");

        return User
                .withUsername(user.get().getEmail())
                .password(user.get().getPassword())
                // Add roles if any
                /*
                 * .roles("USER")
                 */
                .build();

    }
}