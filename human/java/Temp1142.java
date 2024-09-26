import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.AuthenticationProvider;
import javax.security.auth.login.LoginException;

// Assuming MyAuthenticationService and OTPAuthorizationToken are defined elsewhere
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private MyAuthenticationService sampleService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        OTPAuthorizationToken auth = (OTPAuthorizationToken) authentication;

        String error = sampleService.loginWithOTP(auth.getPrincipal(), auth.getCredentials(), auth.getOTP());
        if (error != null) {
            throw new LoginException(error);
        }

        auth.setAuthenticated(true);

        return auth;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return OTPAuthorizationToken.class.isAssignableFrom(authentication);
    }
}