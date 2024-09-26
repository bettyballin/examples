import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsContextMapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Component
public class MyUserDetailsContextMapper implements UserDetailsContextMapper {
    @Override
    public void mapUserToContext(UserDetails user, Object context) {
        // Custom logic for mapping users
    }

    @Override
    public UserDetails mapUserFromContext(Object context, String username, Collection<? extends GrantedAuthority> authorities) {
        // Custom logic for mapping from context to user
        return new User(username, "", authorities);
    }
}