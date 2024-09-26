import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.List;

public class SecurityConfig39 {

    public static void setupSecurityContext(String username, String password, String... groups) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String group : groups) {
            authorities.add(new SimpleGrantedAuthority(group));
        }

        User user = new User(username, password, authorities);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user, password, authorities);
        SecurityContextHolder.getContext().setAuthentication(token);
    }
}