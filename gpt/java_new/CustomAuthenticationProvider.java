import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final YourServiceClass service;

    public CustomAuthenticationProvider(YourServiceClass service) {
        this.service = service;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        if (service.doAuthenticate(username, password)) {
            UserDetails principal = new User(username, password, Collections.singleton(new SimpleGrantedAuthority("USER")));
            return new UsernamePasswordAuthenticationToken(principal, password, principal.getAuthorities());
        } else {
            throw new UsernameNotFoundException("Authentication failed for user: " + username);
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}