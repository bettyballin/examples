import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Temp3374 {
    public static void main(String[] args) {
        // Example usage
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(new Role("ROLE_USER"));
        userRoles.add(new Role("ROLE_ADMIN"));

        Temp3374 temp = new Temp3374();
        List<GrantedAuthority> authorities = temp.getAuthoritiesEntities(userRoles);
        authorities.forEach(authority -> System.out.println(authority.getAuthority()));
    }

    private List<GrantedAuthority> getAuthoritiesEntities(Set<Role> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<>();
        userRoles.forEach((role) -> {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        });

        return new ArrayList<>(roles);
    }
}

class Role {
    private String role;

    public Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}