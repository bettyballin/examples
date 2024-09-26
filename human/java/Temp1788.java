import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

public class Temp1788 {
    public static void main(String[] args) {
        setupSecurityContext("user1", "password1", "ROLE_USER", "ROLE_ADMIN");
    }

    public static void setupSecurityContext(String username, String password, String... groups) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String group : groups) {
            authorities.add(new SimpleGrantedAuthority(group));
        }

        UserDetails user = org.springframework.security.core.userdetails.User.withUsername(username)
                .password(password)
                .authorities(authorities)
                .build();
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user, password, authorities);
        SecurityContextHolder.getContext().setAuthentication(token);
    }
}