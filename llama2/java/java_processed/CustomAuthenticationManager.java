import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class CustomAuthenticationManager implements AuthenticationManager {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String pw = authentication.getCredentials().toString();

        // Make REST call to BackendApp using provided credentials
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(username + ":" + pw, headers);
        String response = restTemplate.postForObject("http://localhost:8080/api/authenticate", entity, String.class);

        // Check if response is 200 OK or 401 Unauthorized
        int statusCode = Integer.parseInt(response.split(" ")[1]);
        if (statusCode == 200) {
            return new UsernamePasswordAuthenticationToken(username, pw, null);
        } else {
            throw new AuthenticationException("Authentication failed") {};
        }
    }

    public static void main(String[] args) {
        // Example usage
        CustomAuthenticationManager manager = new CustomAuthenticationManager();
        Authentication auth = new UsernamePasswordAuthenticationToken("user", "password");
        try {
            Authentication result = manager.authenticate(auth);
            if (result.isAuthenticated()) {
                System.out.println("Authentication successful!");
            } else {
                System.out.println("Authentication failed.");
            }
        } catch (AuthenticationException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        }
    }
}