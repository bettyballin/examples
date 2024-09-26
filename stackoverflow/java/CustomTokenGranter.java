import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.BadCredentialsException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.security.oauth2.provider.token.AbstractTokenGranter;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.util.Map;

public class CustomTokenGranter extends AbstractTokenGranter {
    private final AuthenticationManager authenticationManager;

    public CustomTokenGranter(AuthenticationManager authenticationManager) {
        // You might need to pass other parameters to the super class constructor based on your actual use case.
        super(authenticationManager, null, null, null);
        this.authenticationManager = authenticationManager;
    }

    @Override
    protected OAuth2Authentication getOAuth2Authentication(ClientDetails client, TokenRequest tokenRequest) {
        Map<String, String> params = tokenRequest.getRequestParameters();
        String username = params.get("username");
        String password = params.get("password");

        if (username == null || password == null) {
            throw new BadCredentialsException("Bad credentials");
        }

        CustomAuthenticationToken token = new CustomAuthenticationToken(username, password);

        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(token);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Bad credentials", e);
        }

        return new OAuth2Authentication(tokenRequest.createOAuth2Request(client), authentication);
    }
}

class CustomAuthenticationToken implements Authentication {
    private final String username;
    private final String password;

    public CustomAuthenticationToken(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Implement all abstract methods of the Authentication interface
    // ...
}