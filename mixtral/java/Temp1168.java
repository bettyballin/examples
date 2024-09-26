import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;

public class Temp1168 {
    private TokenProvider tokenProvider;
    private static final String LDAP_USER_ROLE = "LDAP_USER_ROLE";
    private static final String AUTHORIZATION_HEADER = "Authorization";

    public static void main(String[] args) {
        new Temp1168().execute();
    }

    public Temp1168() {
        // Initialize tokenProvider here (this is just a placeholder)
        this.tokenProvider = new TokenProvider();
    }

    public void execute() {
        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();

        boolean hasRole = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(role -> role.equalsIgnoreCase(LDAP_USER_ROLE));

        if (hasRole) {
            String jwt = tokenProvider.createToken(authentication, true);
            // Assuming we have a response object to add headers to
            // For demonstration purposes, we print the header instead
            System.out.println(AUTHORIZATION_HEADER + ": Bearer " + jwt);
            System.out.println(ResponseEntity.ok(new JWTToken(jwt)));
        } else {
            System.out.println(new ResponseEntity<>(HttpStatus.FORBIDDEN));
        }
    }

    // Placeholder classes for TokenProvider and JWTToken
    class TokenProvider {
        public String createToken(Authentication authentication, boolean rememberMe) {
            // Dummy implementation
            return "dummy-jwt-token";
        }
    }

    class JWTToken {
        private String token;

        public JWTToken(String token) {
            this.token = token;
        }

        @Override
        public String toString() {
            return "{token: \"" + token + "\"}";
        }
    }
}