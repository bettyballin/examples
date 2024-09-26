import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Dummy implementation for example purposes.
        if ("user".equals(username)) {
            return org.springframework.security.core.userdetails.User
                    .withUsername("user")
                    .password("password")
                    .roles("USER")
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}

public class Temp248 {
    public static void main(String[] args) {
        UserDetailsService userDetailsService = new CustomUserDetailsService();
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername("user");
            System.out.println("User found: " + userDetails.getUsername());
        } catch (UsernameNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}