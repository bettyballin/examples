import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;

public class Temp764 {
    public static void main(String[] args) {
        Temp764 temp = new Temp764();
        try {
            UserDetails userDetails = temp.loadUserByUsername("testUser");
            System.out.println("User details loaded: " + userDetails.getUsername());
        } catch (UsernameNotFoundException e) {
            System.out.println("User not found: " + e.getMessage());
        }
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String password = "password"; // Dummy password for demonstration
        // Fetch user details from database or other source

        return new User(username, "{noop}" + password, true, true, true, true, Collections.emptyList());
    }
}