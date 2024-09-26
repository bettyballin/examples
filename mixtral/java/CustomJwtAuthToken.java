import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.authentication.AbstractAuthenticationToken;

import java.util.Collection;
import java.util.Objects;

public final class CustomJwtAuthToken extends AbstractAuthenticationToken {
    private static final long serialVersionUID = 1L;

    // User ID
    private final String userId;

    public CustomJwtAuthToken(String principal, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);

        this.userId = Objects.requireNonNull(principal);

        setAuthenticated(true);
    }

    @Override
    public String getName() {
        return userId;
    }

    @Override
    public Object getCredentials() {
        return null; // As this is JWT-based, no credentials are stored here
    }

    @Override
    public Object getPrincipal() {
        return userId;
    }
}