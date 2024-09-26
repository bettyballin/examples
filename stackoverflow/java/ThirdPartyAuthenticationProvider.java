import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class ThirdPartyAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        // call third party site with auth.getPrincipal() and auth.getCredentials() (those are username and password)
        // Throw AuthenticationException if response is not 200
        return new UsernamePasswordAuthenticationToken(auth.getPrincipal(), auth.getCredentials());
    }

    @Override
    public boolean supports(Class<?> authCls) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authCls);
    }
}