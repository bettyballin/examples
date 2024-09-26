import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class Temp1923 {

    public static void main(String[] args) {
        // Your main logic here
    }

    protected List<GrantedAuthority> loadUserAuthorities(String username) {
        // Your implementation here
        return null;
    }

    public UserDetails createUserDetails(String username, UserDetails userFromUserQuery,
                                         List<GrantedAuthority> combinedAuthorities) throws UsernameNotFoundException {
        // Your implementation here
        return userFromUserQuery;
    }
}