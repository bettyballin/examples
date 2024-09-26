import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.authentication.BadCredentialsException;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        // Make REST call here and check for OK or Unauthorized
        boolean isAuthenticated = makeRestCall(name, password);

        if (isAuthenticated) {
            return new UsernamePasswordAuthenticationToken(
                    name,
                    password,
                    AuthorityUtils.createAuthorityList("ROLE_USER"));
        }

        throw new BadCredentialsException("Authentication failed");
    }

    private boolean makeRestCall(String name, String password) {
        // Implement REST call here and return true if successful, otherwise false
        // For illustration, let's assume the authentication is always successful
        return true; 
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}