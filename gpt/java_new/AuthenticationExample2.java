import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class AuthenticationExample2 {
    public Authentication createNewAuthentication(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        Authentication newAuth = new UsernamePasswordAuthenticationToken(principal, credentials, authorities);
        return newAuth;
    }
}