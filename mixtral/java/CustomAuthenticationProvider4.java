import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collections;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        String username = (String) auth.getPrincipal();
        String password = (String) auth.getCredentials();

        int resultCode = callPLSQLFunction(username, password);

        if (resultCode == 0 /* successful authentication */) {
            return new UsernamePasswordAuthenticationToken(username, null, Collections.<GrantedAuthority>emptyList());
        } else {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    private int callPLSQLFunction(String username, String password) {
        // Implement your PL/SQL function call here and return the result code
        // For demonstration purposes, let's assume the function returns 0 for success
        return 0; // Dummy implementation for demonstration
    }

    @Override
    public boolean supports(Class<?> auth) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(auth));
    }

    public static void main(String[] args) {
        // For demonstration purposes, create an instance and test the authenticate method
        CustomAuthenticationProvider provider = new CustomAuthenticationProvider();
        Authentication authentication = new UsernamePasswordAuthenticationToken("user", "password");

        try {
            Authentication result = provider.authenticate(authentication);
            System.out.println("Authentication successful: " + result);
        } catch (AuthenticationException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        }
    }
}