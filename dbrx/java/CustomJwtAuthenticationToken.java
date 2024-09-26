import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import java.util.Collection;

public class CustomJwtAuthenticationToken extends AbstractAuthenticationToken {

    private final String id;
    private final Collection<? extends GrantedAuthority> authorities;

    public CustomJwtAuthenticationToken(String id, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.id = id;
        this.authorities = authorities;
        
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null; // or your custom credentials if needed
    }

    @Override
    public Object getPrincipal() {
        return id;
    }
}