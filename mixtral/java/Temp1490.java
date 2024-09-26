import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Temp1490 {

    public static void main(String[] args) {
        // Your main method logic here
    }

    //@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Load your user and roles here

        // Assuming loadedRolesFromDatabase is a list of Role objects fetched from the database
        List<Role> loadedRolesFromDatabase = new ArrayList<>();
        
        // Assuming Role is a class with a getName() method
        class Role {
            private String name;

            public Role(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }
        }

        // Adding some roles for demonstration
        loadedRolesFromDatabase.add(new Role("USER"));
        loadedRolesFromDatabase.add(new Role("ADMIN"));

        List<GrantedAuthority> grantedAuths = new ArrayList<>();

        for (Role role : loadedRolesFromDatabase) {
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role.getName());
            grantedAuths.add(authority);
        }

        // Assuming loadedUser and other variables are fetched from the database
        String loadedUser = "testUser";
        String password = "password";
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        return new User(loadedUser, password, enabled, accountNonExpired, credentialsNonExpired,
                accountNonLocked, grantedAuths);
    }
}