import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import javax.security.auth.login.LoginException;

public class CustomAuthenticationProvider1 implements AuthenticationProvider {

    private final MyAuthenticationService sampleService;

    @Autowired
    public CustomAuthenticationProvider1(MyAuthenticationService sampleService) {
        this.sampleService = sampleService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {
            LDAPAuthorizationToken auth = (LDAPAuthorizationToken) authentication;

            String username = sampleService.verifyToken(auth.getCredentials());
            if (username == null) {
                throw new LoginException("Invalid Token");
            }

            auth.setAuthenticated(true);

            return auth;
        } catch (ClassCastException e) {
            throw new AuthenticationException("Unsupported authentication type") {};
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return LDAPAuthorizationToken.class.isAssignableFrom(authentication);
    }
}