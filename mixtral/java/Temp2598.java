import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.List;

public class Temp2598 {
    // Assuming User and Role classes are defined elsewhere in your codebase
    private User user;

    public static void main(String[] args) {
        // Assuming you have a user object initialized with roles
        Temp2598 temp = new Temp2598();
        temp.user = new User(); // Initialize the user with roles
        Collection<? extends GrantedAuthority> authorities = temp.getAuthorities();
        // Do something with the authorities
    }

    @Transactional
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getRoles().stream()
                .map(r -> new SimpleGrantedAuthority(r.getName()))
                .collect(Collectors.toList());
    }
}

// Dummy User and Role classes for demonstration
class User {
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}

class Role {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}