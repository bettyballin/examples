import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import java.util.Collection;

public class CustomUserDetails extends User {
    private final boolean isAdmin;

    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, 
                             boolean isEnabled, boolean isAccountNonExpired, boolean isCredentialsNonExpired, 
                             boolean isAccountNonLocked, boolean isAdmin) {
        super(username, password, authorities);
        this.isAdmin = isAdmin;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}