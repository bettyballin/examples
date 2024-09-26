import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class CustomTokenAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication a) throws AuthenticationException {
        String token = ((CustomTokenAuthenticationRequest) a).getToken();
        if (isValidToken(token)) {
            CustomTokenAuthentication returnValue = new CustomTokenAuthentication(token, true);
            return returnValue;
        }
        throw new BadCredentialsException("Invalid token");
    }

    @Override
    public boolean supports(Class<?> authClass) {
        return authClass == CustomTokenAuthenticationRequest.class;
    }

    private boolean isValidToken(String token) {
        // Implement your token validation logic here
        return "valid-token".equals(token);
    }
    
    public static void main(String[] args) {
        CustomTokenAuthenticationProvider provider = new CustomTokenAuthenticationProvider();
        CustomTokenAuthenticationRequest request = new CustomTokenAuthenticationRequest("valid-token");
        
        try {
            Authentication auth = provider.authenticate(request);
            System.out.println("Authentication successful: " + auth.isAuthenticated());
        } catch (BadCredentialsException e) {
            System.out.println(e.getMessage());
        }
    }
}

class CustomTokenAuthenticationRequest implements Authentication {
    private final String token;
    private boolean authenticated = false;

    public CustomTokenAuthenticationRequest(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }
}

class CustomTokenAuthentication implements Authentication {
    private final String token;
    private boolean authenticated;

    public CustomTokenAuthentication(String token, boolean authenticated) {
        this.token = token;
        this.authenticated = authenticated;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        return null;
    }
}