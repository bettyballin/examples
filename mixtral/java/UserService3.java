import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService implements UserDetailsService {

    // Dummy method to simulate user retrieval, replace with actual implementation
    private UserDetails find(String username) throws UsernameNotFoundException {
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return find(username);
    }

    public static void main(String[] args) {
        UserService userService = new UserService();
        try {
            UserDetails userDetails = userService.loadUserByUsername("user");
            System.out.println("User found: " + userDetails.getUsername());
        } catch (UsernameNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}