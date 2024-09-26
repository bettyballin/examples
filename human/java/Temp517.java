import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class Temp517 {
    public static void main(String[] args) {
        // This part of the code requires a Spring Security context which is typically set up in a web application.
        // We will simulate authentication for demonstration purposes.
        
        // Simulate setting up an authentication context
        Authentication authentication = new MockAuthentication("user123");
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        // Now we can retrieve the username
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        System.out.println("Authenticated username: " + username);
    }
}

// MockAuthentication class to simulate an Authentication object
class MockAuthentication implements Authentication {
    private String name;

    public MockAuthentication(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        // No-op for mock
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public Object getPrincipal() {
        return name;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
}