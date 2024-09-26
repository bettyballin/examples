import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;
import org.springframework.security.oauth2.core.oidc.StandardClaimNames;

public class MyAuthentication extends JwtAuthenticationToken {
    public MyAuthentication(Jwt jwt, Collection<? extends GrantedAuthority> authorities) {
        super(jwt, authorities);
    }
    
    @Override
    public String getPrincipal() {
        return getToken().getClaimAsString(StandardClaimNames.PREFERRED_USERNAME);
    }   
}