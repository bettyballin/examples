import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class OTPAuthenticationProvider implements AuthenticationProvider {

    private final MyAuthenticationService sampleService;

    @Autowired
    public OTPAuthenticationProvider(MyAuthenticationService sampleService) {
        this.sampleService = sampleService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        OTPAuthorizationToken auth = (OTPAuthorizationToken)authentication;

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

class OTPAuthorizationToken extends Authentication {
    // Implementation details
}

class MyAuthenticationService {
    // Implementation details
    String loginWithOTP(Object principal, Object credentials, Object otp) {
        // Implementation details
        return null;
    }
}

class LoginException extends AuthenticationException {
    public LoginException(String msg) {
        super(msg);
    }
}