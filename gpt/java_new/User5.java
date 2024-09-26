import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Set;
import java.util.HashSet;

public class User5 {
    private String role = "USER"; // Existing role without prefix

    public Set<GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.role));
        return authorities;
    }

    public void insertRoleWithPrefix() {
        String roleWithPrefix = "ROLE_" + role;
        // Insert roleWithPrefix into the database
    }
}