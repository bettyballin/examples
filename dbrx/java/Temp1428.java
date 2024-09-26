import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;

public class Temp1428 {
    public static void main(String[] args) {
        Temp1428 temp = new Temp1428();
        Authentication auth = temp.getAuthentication();
        System.out.println(auth);
    }

    private Authentication getAuthentication() {
        Collection<? extends GrantedAuthority> authorities =
                AuthorityUtils.createAuthorityList("ROLE_USER");
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(
                        "username", "password", authorities);
        token.setAuthenticated(true);
        return token;
    }
}