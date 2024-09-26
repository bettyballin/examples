import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class YourClassName3 {
    private class Role {
        String getRole() {
            // Dummy implementation, replace with actual role retrieval logic
            return "USER";
        }
    }
    
    private List<GrantedAuthority> getAuthoritiesEntities(Set<Role> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<>();
        userRoles.forEach(role -> roles.add(new SimpleGrantedAuthority(role.getRole())));
        return new ArrayList<>(roles);
    }
}