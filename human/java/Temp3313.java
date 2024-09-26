import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;

public class Temp3313 {
    public static void main(String[] args) {
        // Mocking SecurityContextHolder for the sake of example
        // In a real Spring Security environment, this would be managed by the framework
        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
        SecurityContextHolder.getContext().setAuthentication(new MockAuthentication());

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("Principal: " + principal);
    }

    // Mock Authentication class for demonstration purposes
    static class MockAuthentication implements Authentication {
        @Override
        public String getName() {
            return "mockUser";
        }

        @Override
        public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        }

        @Override
        public boolean isAuthenticated() {
            return true;
        }

        @Override
        public Object getPrincipal() {
            return "mockPrincipal";
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
}