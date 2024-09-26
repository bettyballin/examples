import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;
import java.util.Collections;

public class Temp2138 {
    public static void main(String[] args) {
        String userId = "exampleUserId"; // Extract from JWT
        Collection<? extends GrantedAuthority> authorities = Collections.emptyList(); // Map your custom claims to Spring Security's granted authority
        
        Authentication authentication = new CustomJwtAuthToken(userId, null, authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        System.out.println("Authentication set in SecurityContextHolder.");
    }
}

class CustomJwtAuthToken implements Authentication {

    private final String userId;
    private final Collection<? extends GrantedAuthority> authorities;
    private boolean authenticated = true;

    public CustomJwtAuthToken(String userId, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        this.userId = userId;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
        return userId;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        return userId;
    }
}