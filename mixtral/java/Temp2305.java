import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashSet;
import java.util.Set;

public class Temp2305 {

    public static void main(String[] args) {

        // Dummy userEntity and RoleEntity for the sake of example
        UserEntity userEntity = new UserEntity();
        userEntity.addRole(new RoleEntity("USER"));
        userEntity.addRole(new RoleEntity("ADMIN"));

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (RoleEntity authority : userEntity.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + authority.getName()));
        }

        UserDetails user = new org.springframework.security.core.userdetails.User(
                "va@va.va", // username
                "1111",     // password
                true,       // enabled
                true,       // accountNonExpired
                true,       // credentialsNonExpired
                true,       // accountNonLocked
                grantedAuthorities
        );

        System.out.println("User: " + user);
    }
}

class UserEntity {
    private Set<RoleEntity> roles = new HashSet<>();

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void addRole(RoleEntity role) {
        roles.add(role);
    }
}

class RoleEntity {
    private String name;

    public RoleEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}