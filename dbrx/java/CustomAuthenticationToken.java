import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.authentication.AbstractAuthenticationToken;

import java.util.Collection;
import java.util.Collections;

public class CustomAuthenticationToken extends AbstractAuthenticationToken {

    private final Object principal;
    private final Collection<? extends GrantedAuthority> authorities;

    public CustomAuthenticationToken(Object principal, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.authorities = authorities;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null; 
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getName() {
        return principal.toString();
    }

    public static void main(String[] args) {
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
        CustomAuthenticationToken token = new CustomAuthenticationToken("user", Collections.singleton(authority));

        System.out.println("Principal: " + token.getPrincipal());
        System.out.println("Authorities: " + token.getAuthorities());
    }
}