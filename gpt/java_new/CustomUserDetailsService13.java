import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;

public class CustomUserDetailsService13 implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Your logic to retrieve the user from your data source
        // Placeholder for demonstration - replace with your user retrieval logic
        UserDetails user = User.builder()
                .username(username)
                .password("password")
                .roles("USER")
                .build();

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return user;
    }
}