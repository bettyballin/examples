import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class Temp3480 {
    public static void main(String[] args) {
        // Simulate setting up a security context for testing
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        Authentication authentication = new Authentication() {
            @Override
            public String getName() {
                return "testUser";
            }

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public Object getCredentials() {
                return null;
            }

            @Override
            public Object getDetails() {
                return "Test Details";
            }

            @Override
            public Object getPrincipal() {
                return null;
            }

            @Override
            public boolean isAuthenticated() {
                return true;
            }

            @Override
            public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
            }
        };
        context.setAuthentication(authentication);
        SecurityContextHolder.setContext(context);

        // Extracting authentication details
        context = SecurityContextHolder.getContext();
        authentication = context.getAuthentication();
        Object details = authentication.getDetails();

        // Print details
        System.out.println("Authentication Details: " + details);
    }
}