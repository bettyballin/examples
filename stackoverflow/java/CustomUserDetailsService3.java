import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.dao.DataAccessException;

import java.util.Collections;

public class CustomUserDetailsService3 implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException {
        System.out.println("Getting access details from employee dao !!");

        UserDetails user = new User(username, "password", true, true, true, true,
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
        return user;
    }
}