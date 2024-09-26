import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.AuthenticationException;

import java.util.Collections;

public class Temp810 {

    public static void main(String[] args) {

        String username = "your-username";
        String password = "<PASSWORD>";

        UsernamePasswordAuthenticationToken authRequest =
                new UsernamePasswordAuthenticationToken(username, password);

        AuthenticationManager authenticationManager = new CustomAuthenticationManager();
        try {
            Authentication authentication = authenticationManager.authenticate(authRequest);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            System.out.println("Authentication successful!");
        } catch (AuthenticationException e) {
            System.out.println("Invalid username or password");
        }
    }
}

class CustomAuthenticationManager implements AuthenticationManager {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        // Mock authentication logic for demonstration (replace with real logic)
        if ("your-username".equals(username) && "<PASSWORD>".equals(password)) {
            User user = new User(username, password, Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
            return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        } else {
            throw new org.springframework.security.authentication.AuthenticationCredentialsNotFoundException("Authentication failed", new Throwable("Authentication failed"));
        }
    }
}