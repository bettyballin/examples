import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;

public class Temp3392 {
    public static void main(String[] args) {
        Temp3392 temp = new Temp3392();
        // Example usage
        Authentication auth = new UsernamePasswordAuthenticationToken("user@example.com", "password");
        try {
            Authentication result = temp.authenticate(auth);
            System.out.println("Authentication successful: " + result.isAuthenticated());
        } catch (AuthenticationException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        }
    }

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        var email = authentication.getName();
        var password = authentication.getCredentials().toString();
        // Call here to backend to check login
        Collection<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("USER"));
        return new UsernamePasswordAuthenticationToken(email, password, roles);
    }
}