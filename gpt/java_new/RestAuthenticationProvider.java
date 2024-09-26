import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class RestAuthenticationProvider implements AuthenticationProvider {

    private RestWebService restWebService;

    // Constructor to inject the RestWebService
    public RestAuthenticationProvider(RestWebService restWebService) {
        this.restWebService = restWebService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        // Call your REST service here and get the token
        String token = restWebService.authenticate(username, password);

        if (token == null) {
            throw new BadCredentialsException("External system authentication failed");
        }

        // You can store additional details in the token object as necessary
        List<GrantedAuthority> authorities = new ArrayList<>();
        // Add authorities based on the token or other details

        // Assuming TokenBasedAuthentication is a custom Authentication implementation
        return new TokenBasedAuthentication(token, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return Authentication.class.isAssignableFrom(authentication);
    }
    
    // Rest of the necessary code...
}