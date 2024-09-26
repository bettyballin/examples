import org.apache.wss4j.dom.handler.RequestData;
import org.apache.wss4j.dom.validate.UsernameTokenValidator;
import org.apache.wss4j.dom.WSSecurityException;
import org.apache.wss4j.dom.message.token.UsernameToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import java.util.ArrayList;
import java.util.List;

public class CredentialValidator extends UsernameTokenValidator {

    @Override
    public Credential validate(UsernameToken usernameToken, RequestData data) throws WSSecurityException {
        String userName = usernameToken.getName();
        String password = "password"; // Replace with actual password retrieval logic

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        PreAuthenticatedAuthenticationToken token =
                new PreAuthenticatedAuthenticationToken(
                        userName, password, authorities);

        // Set the authenticated flag to true
        token.setAuthenticated(true);
        SecurityContextHolder.getContext().setAuthentication(token);

        return new Credential(userName, password); // Return a Credential object
    }

    // Define the Credential class
    public static class Credential {
        private String username;
        private String password;

        public Credential(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }
}