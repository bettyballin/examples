import java.util.Collection;

public class Temp2249 {
    public static void main(String[] args) {
        // Example usage
        Object principal = "user";
        Object credentials = "password";
        Collection<GrantedAuthority> authorities = null; // Replace with actual authorities

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(principal, credentials, authorities);
        System.out.println("Token created: " + token);
    }
}

class UsernamePasswordAuthenticationToken extends AbstractAuthenticationToken {
    private final Object principal;
    private Object credentials;

    public UsernamePasswordAuthenticationToken(Object principal, Object credentials,
                                               Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.credentials = credentials;
        super.setAuthenticated(true); // must use super, as we override
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

abstract class AbstractAuthenticationToken {
    private Collection<? extends GrantedAuthority> authorities;
    private boolean authenticated = false;

    public AbstractAuthenticationToken(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public abstract Object getCredentials();

    public abstract Object getPrincipal();
}

interface GrantedAuthority {
    String getAuthority();
}