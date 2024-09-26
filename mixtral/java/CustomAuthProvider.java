import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;

@Component
public class CustomAuthProvider implements AuthenticationProvider {

    @Autowired
    private RestartService restartService;

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        if (auth instanceof UsernamePasswordAuthenticationToken &&
            "/restart".equalsIgnoreCase((String) auth.getPrincipal())) {

            // Perform custom authentication logic here
            boolean isAuthenticated = restartService.authenticate();

            return new PreAuthenticatedAuthenticationToken(
                "Restart",
                null,
                isAuthenticated ? Collections.<GrantedAuthority>emptyList()
                                : Arrays.asList(new SimpleGrantedAuthority("ROLE_RESTART"))
            );
        }

        return null;
    }
}

interface RestartService {
    boolean authenticate();
}