import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;

public class CustomAuthenticationToken extends AbstractAuthenticationToken {
    private User user;

    public CustomAuthenticationToken(User user) {
        super(null);
        this.user = user;
        setAuthenticated(true); // You can set it to false if not authenticated initially
    }

    @Override
    public Object getCredentials() {
        return null; // You can return any credentials if needed
    }

    @Override
    public Object getPrincipal() {
        return this.user;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return user.getAuthorities(); // Assuming User class has a method to get authorities
    }

    public static void main(String[] args) {
        // for testing purposes
    }
}

class User {
    private String username;
    private Collection<GrantedAuthority> authorities;

    public User(String username, Collection<GrantedAuthority> authorities) {
        this.username = username;
        this.authorities = authorities;
    }

    public String getUsername() {
        return username;
    }

    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }
}