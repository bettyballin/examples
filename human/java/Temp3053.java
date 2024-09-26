import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class Temp3053 {
    public static void main(String[] args) {
        // Simulate a security context and authentication for demonstration purposes
        // In a real application, this would be handled by Spring Security
        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_GLOBAL);
        Authentication authentication = new MockAuthentication("user1");
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Retrieve the current user's name
        String currentUserName = authentication.getName();
        System.out.println("Current User Name: " + currentUserName);
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
        return this.name;
    }

    // Other methods from the Authentication interface
    @Override public Collection<? extends GrantedAuthority> getAuthorities() { return null; }
    @Override public Object getCredentials() { return null; }
    @Override public Object getDetails() { return null; }
    @Override public Object getPrincipal() { return null; }
    @Override public boolean isAuthenticated() { return true; }
    @Override public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {}
}