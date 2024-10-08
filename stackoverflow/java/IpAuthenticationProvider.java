import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

public class IpAuthenticationProvider implements AuthenticationProvider {

    private AuthenticationProvider delegate;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String address = ((WebAuthenticationDetails) authentication.getDetails()).getRemoteAddress();

        // Throw an AuthenticationException if there's a bad IP here

        return delegate.authenticate(authentication);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return delegate.supports(aClass);
    }

    public void setDelegate(AuthenticationProvider delegate) {
        this.delegate = delegate;
    }
}