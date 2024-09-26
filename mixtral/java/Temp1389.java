import java.util.Collection;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class Temp1389 {
    public static void main(String[] args) {
        // Example usage
        Object principal = "user";
        Object credentials = "password";
        Collection<? extends GrantedAuthority> authorities = null;

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(principal, credentials, authorities);
        System.out.println("Principal: " + token.getPrincipal());
        System.out.println("Credentials: " + token.getCredentials());
    }
}

class UsernamePasswordAuthenticationToken extends AbstractAuthenticationToken {
    private final Object principal;
    private Object credentials;

    public UsernamePasswordAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.credentials = credentials;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return this.credentials;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }
}