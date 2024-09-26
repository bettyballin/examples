import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.security.oauth2.provider.token.AbstractTokenGranter;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.util.Map;
import org.springframework.security.authentication.BadCredentialsException;

public class CustomTokenGranter extends AbstractTokenGranter {

    private final AuthenticationManager authenticationManager;

    public CustomTokenGranter(AuthorizationServerTokenServices tokenServices, ClientDetails clientDetails,
                              AuthenticationManager authenticationManager) {
        super(tokenServices, clientDetails, "custom");
        this.authenticationManager = authenticationManager;
    }

    @Override
    protected OAuth2Authentication getOAuth2Authentication(ClientDetails client, TokenRequest tokenRequest) {
        Map<String, String> params = tokenRequest.getRequestParameters();
        String username = params.getOrDefault("username", null);
        String password = params.getOrDefault("password", null);

        if (username == null || password == null) {
            throw new BadCredentialsException("Bad credentials");
        }

        CustomAuthenticationToken token = new CustomAuthenticationToken(username, password);

        try {
            Authentication authentication = authenticationManager.authenticate(token);
            return new OAuth2Authentication(tokenRequest.createOAuth2Request(client), authentication);
        } catch (AuthenticationException e) {
            throw new InvalidGrantException(e.getMessage());
        }
    }
}

// Assuming CustomAuthenticationToken is defined elsewhere
class CustomAuthenticationToken implements Authentication {
    private final String username;
    private final String password;

    public CustomAuthenticationToken(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getName() {
        return username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public Object getCredentials() {
        return password;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return username;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        // Do nothing
    }
}