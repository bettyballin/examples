import org.springframework.security.authentication.jaas.AuthorityGranter;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import java.util.Collection;

public class MyAuthentication extends JwtAuthenticationToken {
    public MyAuthentication(Jwt jwt, Collection<? extends GrantedAuthority> authorities) {
        super(jwt, authorities);
    }

    @Override
    public Object getPrincipal() {
        return getToken().getClaimAsString("preferred_username");
    }
}