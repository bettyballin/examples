import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;

public class ClusterInternalAuthenticationProvider implements AuthenticationProvider {

    public static final String USER = "your_username";
    public static final String PASSWORD = "your_password";

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;

        Object principal = token.getPrincipal();
        Object credentials = token.getCredentials();

        if (principal.equals(USER) && credentials.equals(PASSWORD)) {
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
        return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
    }
}