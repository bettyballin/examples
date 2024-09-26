import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private YourEntity yourEntity;

    // Constructor
    public CustomUserDetails(YourEntity user) {
        this.yourEntity = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Implement your logic to return authorities
        return null; // Replace with actual implementation
    }

    @Override
    public String getPassword() {
        // Implement your logic to return password
        return yourEntity.getPassword(); // Example implementation
    }

    @Override
    public String getUsername() {
        // Implement your logic to return username
        return yourEntity.getUsername(); // Example implementation
    }

    @Override
    public boolean isAccountNonExpired() {
        // Implement your logic
        return true; // Example implementation
    }

    @Override
    public boolean isAccountNonLocked() {
        // Implement your logic
        return true; // Example implementation
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Implement your logic
        return true; // Example implementation
    }

    @Override
    public boolean isEnabled() {
        // Implement your logic
        return true; // Example implementation
    }
}