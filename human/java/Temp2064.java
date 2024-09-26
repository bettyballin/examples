import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;

public class Temp2064 implements UserDetailsService {

    public static void main(String[] args) {
        Temp2064 temp = new Temp2064();
        try {
            UserDetails user = temp.loadUserByUsername("testUser");
            System.out.println("User: " + user.getUsername());
        } catch (UsernameNotFoundException | DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException {
        System.out.println("Getting access details from employee dao !!");

        // Ideally it should be fetched from database and populated instance of
        // #org.springframework.security.core.userdetails.User should be returned from this method
        UserDetails user = new User(username, "password", true, true, true, true,
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
        return user;
    }
}