import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.stereotype.Component;

@Component
public class Temp2106 {

    @Autowired
    private KeycloakAuthenticationProvider kcAuth;

    public static void main(String[] args) {
        Temp2106 temp = new Temp2106();
        System.out.println(temp.getCurrentUser());
    }

    public String getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && auth instanceof KeycloakToken)
            return ((KeycloakToken) auth).getName();

        // If the user is not authenticated try to get it from keycloak

        Authentication kcAuth = this.kcAuth.authenticate(auth);

        if (kcAuth != null && kcAuth instanceof KeycloakToken)
            return ((KeycloakToken) kcAuth).getName();

        return null;
    }

    private static class KeycloakToken implements Authentication {
        @Override
        public String getName() {
            return "John Doe";
        }

        // Implement other methods of Authentication interface as needed
        @Override public Collection<? extends GrantedAuthority> getAuthorities() { return null; }
        @Override public Object getCredentials() { return null; }
        @Override public Object getDetails() { return null; }
        @Override public Object getPrincipal() { return null; }
        @Override public boolean isAuthenticated() { return false; }
        @Override public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {}
    }

    @Component
    private static class KeycloakAuthenticationProvider implements AuthenticationProvider {
        @Override
        public Authentication authenticate(Authentication authentication) {
            return new KeycloakToken();
        }

        @Override
        public boolean supports(Class<?> authentication) {
            return true;
        }
    }
}