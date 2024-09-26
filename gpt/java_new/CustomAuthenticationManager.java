import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class CustomAuthenticationManager implements AuthenticationManager {

    private final RestTemplate restTemplate;
    private final String backendAppAuthenticationUrl;

    public CustomAuthenticationManager(RestTemplate restTemplate, String backendAppAuthenticationUrl) {
        this.restTemplate = restTemplate;
        this.backendAppAuthenticationUrl = backendAppAuthenticationUrl;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        try {
            restTemplate.postForEntity(backendAppAuthenticationUrl, new UsernamePasswordAuthenticationToken(username, password), Void.class);
            return new UsernamePasswordAuthenticationToken(username, password, authentication.getAuthorities());
        } catch (HttpClientErrorException e) {
            throw new BadCredentialsException("External system authentication failed", e);
        }
    }
}