import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;

public class AppUDS implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException {
        // Assuming that we have a method that fetches a user's details from DB or another service
        // UserDetails userDetails = fetchUserDetailsFromDataSource(username);

        // Here we just create a default user for the illustration purposes
        UserDetails userDetails = new User(
                username,
                "password", // You would have a password encoder/manager to handle this properly
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")) // Adding a custom role
        );

        return userDetails;
    }

    // Placeholder for an actual data fetching method
    // private UserDetails fetchUserDetailsFromDataSource(String username) {
    //     throw new UsernameNotFoundException("User not found");
    // }
}