import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;

public class Temp2383 {
    public static void main(String[] args) {
        Temp2383 temp = new Temp2383();
        // You would typically call getExpiringUserAuth() within a Spring context.
    }

    @ModelAttribute("token")
    public ExpiringUsernameAuthenticationToken getExpiringUserAuth() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth instanceof ExpiringUsernameAuthenticationToken)
            return ((ExpiringUsernameAuthenticationToken) auth);

        throw new RuntimeException("Invalid authentication token");
    }
}

class ExpiringUsernameAuthenticationToken implements Authentication {
    // Implement necessary methods for the Authentication interface

    @Override
    public String getName() {
        return null;
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
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public boolean isAuthenticated() {
        return false;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }
}