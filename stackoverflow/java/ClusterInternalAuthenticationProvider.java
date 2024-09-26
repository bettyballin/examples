import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.AuthenticationProvider;
import java.util.Collections;

public class ClusterInternalAuthenticationProvider implements AuthenticationProvider {

    public static final String USER = "...";
    public static final String PASSWORD = "...";

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;

        Object principal = token.getPrincipal();
        Object credentials = token.getCredentials();

        if (USER.equals(principal) && PASSWORD.equals(credentials)) {
            return new UsernamePasswordAuthenticationToken(
                principal,
                credentials,
                Collections.singletonList(new SimpleGrantedAuthority("RELEVANT_AUTHORITY"))
            );
        }

        throw new BadCredentialsException("Sorry mate, wrong credentials...");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}