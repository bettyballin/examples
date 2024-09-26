import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class Temp3489 {
    public static void main(String[] args) {
        // Simulate setting up a security context for demonstration purposes
        SecurityContextHolder.getContext().setAuthentication(new MockAuthentication("exampleUser"));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        System.out.println("Current Principal Name: " + currentPrincipalName);
    }
}

// Mock Authentication class for demonstration purposes
class MockAuthentication implements Authentication {
    private final String name;

    public MockAuthentication(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    // Additional methods from Authentication interface can be implemented as needed
    @Override public Collection<? extends GrantedAuthority> getAuthorities() { return null; }
    @Override public Object getCredentials() { return null; }
    @Override public Object getDetails() { return null; }
    @Override public Object getPrincipal() { return null; }
    @Override public boolean isAuthenticated() { return true; }
    @Override public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException { }
}