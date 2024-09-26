import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import java.util.Collections;

public class Temp213 {
    public static void main(String[] args) {
        User p = new User("username", "password", Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
        PreAuthenticatedAuthenticationToken token = new PreAuthenticatedAuthenticationToken(p, null, p.getAuthorities());
        System.out.println(token);
    }
}