import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class Temp2394 {
    public static void main(String[] args) {
        // Mocking the SecurityContext for demonstration purposes
        SecurityContextHolder.setContext(new MockSecurityContext());

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = userDetails.getUsername();
        System.out.println("Username: " + name);
    }
}

// Mock classes to make the example executable
class MockSecurityContext implements org.springframework.security.core.context.SecurityContext {
    private static final long serialVersionUID = 1L;

    @Override
    public org.springframework.security.core.Authentication getAuthentication() {
        return new MockAuthentication();
    }

    @Override
    public void setAuthentication(org.springframework.security.core.Authentication authentication) {
        // No implementation needed for this mock
    }
}

class MockAuthentication implements org.springframework.security.core.Authentication {
    private static final long serialVersionUID = 1L;

    @Override
    public String getName() {
        return "mockUser";
    }

    @Override
    public UserDetails getPrincipal() {
        return new MockUserDetails();
    }

    // Other methods can be left unimplemented for this mock
    @Override
    public Collection<? extends org.springframework.security.core.GrantedAuthority> getAuthorities() { return null; }
    @Override
    public Object getCredentials() { return null; }
    @Override
    public Object getDetails() { return null; }
    @Override
    public boolean isAuthenticated() { return true; }
    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {}
}

class MockUserDetails implements UserDetails {
    private static final long serialVersionUID = 1L;

    @Override
    public String getUsername() {
        return "mockUser";
    }

    // Other methods can be left unimplemented for this mock
    @Override
    public Collection<? extends org.springframework.security.core.GrantedAuthority> getAuthorities() { return null; }
    @Override
    public String getPassword() { return null; }
    @Override
    public boolean isAccountNonExpired() { return true; }
    @Override
    public boolean isAccountNonLocked() { return true; }
    @Override
    public boolean isCredentialsNonExpired() { return true; }
    @Override
    public boolean isEnabled() { return true; }
}