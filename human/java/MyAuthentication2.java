import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimNames;

import java.util.Collection;

public class MyAuthentication extends AbstractAuthenticationToken {
    private final Jwt jwt;

    public MyAuthentication(Jwt jwt, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.jwt = jwt;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return jwt.getTokenValue();
    }

    @Override
    public Object getPrincipal() {
        return jwt;
    }

    @Override
    public String getName() {
        return jwt.getClaimAsString(JwtClaimNames.PREFERRED_USERNAME);
    }
    
    public Jwt getToken() {
        return this.jwt;
    }
}