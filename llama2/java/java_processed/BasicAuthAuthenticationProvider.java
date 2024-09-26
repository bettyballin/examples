import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.crypto.codec.Base64;

public class BasicAuthAuthenticationProvider implements AuthenticationProvider {

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getPrincipal().toString();
        String password = (String) authentication.getCredentials();

        try {
            // Make a GET request to the third-party service with the provided credentials
            URL url = new URL("https://third-party-service.com/auth");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Basic " + new String(Base64.encode((username + ":" + password).getBytes())));

            // Validate the response
            int statusCode = connection.getResponseCode();
            if (statusCode == 200) {
                // Create an Authentication object representing the user
                GrantedAuthority authority = new SimpleGrantedAuthority("USER");
                User user = new User(username, password, Arrays.asList(authority));
                return new UsernamePasswordAuthenticationToken(user, password, user.getAuthorities());
            } else {
                throw new AuthenticationException("Authentication failed") {};
            }
        } catch (Exception e) {
            throw new AuthenticationException("Authentication failed", e) {};
        }
    }

    public static void main(String[] args) {}
}