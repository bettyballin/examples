import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class ThirdPartyAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        // call third party site with auth.getPrincipal() and auth.getCredentials() (those are username and password)
        String username = auth.getPrincipal().toString();
        String password = auth.getCredentials().toString();

        // Assume we have a method `callThirdPartyService` that returns true if authentication is successful
        if (!callThirdPartyService(username, password)) {
            throw new UsernameNotFoundException("Authentication failed for user: " + username);
        }
        
        return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
    }

    @Override
    public boolean supports(Class<?> authCls) {
        return UsernamePasswordAuthenticationToken.class.equals(authCls);
    }

    private boolean callThirdPartyService(String username, String password) {
        // Simulate calling third party service
        // In real scenario, you would have HTTP request logic here
        return "user".equals(username) && "pass".equals(password);
    }
}