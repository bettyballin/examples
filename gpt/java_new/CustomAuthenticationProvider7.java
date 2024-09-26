import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.authentication.AuthenticationProvider;
import java.util.Collections;

public class CustomAuthenticationProvider7 implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        if (username.equals("sam") && checkDynamicPassword(password)) {
            User principal = new User(username, password, Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
            return new UsernamePasswordAuthenticationToken(principal, password, principal.getAuthorities());
        } else {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    private boolean checkDynamicPassword(String password) {
        // Dummy check, replace with real password validation logic
        return "dynamicPassword".equals(password);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}