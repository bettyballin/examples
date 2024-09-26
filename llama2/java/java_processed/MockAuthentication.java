import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class MockAuthentication implements Authentication {
    private UserDetails mockPrincipal;

    public MockAuthentication(UserDetails mockPrincipal) {
        this.mockPrincipal = mockPrincipal;
    }

    @Override
    public String getName() {
        return "MockUser";
    }

    @Override
    public UserDetails getPrincipal() {
        return mockPrincipal;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        // Ignore
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return mockPrincipal.getAuthorities();
    }

    @Override
    public Object getCredentials() {
        return mockPrincipal.getPassword();
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public void logout() {
        // Ignore
    }

    public static void main(String[] args) {
        // Example usage:
        // MockAuthentication auth = new MockAuthentication(userDetails);
        // System.out.println(auth.getName());
    }
}