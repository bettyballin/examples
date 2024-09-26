import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        // Perform your custom check here.
        if (!isValidUsernameAndPassword(username, password)) {
            throw new BadCredentialsException("Invalid credentials");
        }

        List<GrantedAuthority> authorities = getAuthoritiesForUser(username);
        return new UsernamePasswordAuthenticationToken(username, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

    private boolean isValidUsernameAndPassword(String username, String password) {
        // Implement your custom check here.
        // For example you can compare the current time with a part of the provided password.
        long currentTime = System.currentTimeMillis();
        if (password.contains(Long.toString(currentTime))) {
            return true;
        }
        return false;
    }

    private List<GrantedAuthority> getAuthoritiesForUser(String username) {
        // Implement your logic to retrieve authorities for the user here.

        // For example you can hardcode a list of roles based on the provided username:
        if ("sam".equals(username)) {
            return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
        }
        throw new BadCredentialsException("Invalid credentials");
    }
}