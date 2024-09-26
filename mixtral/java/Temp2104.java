import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.Collection;

public class Temp2104 {
    public static void main(String[] args) {
        // Assuming these services and objects are properly initialized
        UpdateUserService updateUserService = new UpdateUserService();
        AuthenticationManager authenticationManager = new AuthenticationManager();
        Principal principal = new Principal();

        // Update User
        updateUserService.updateUser(principal.getName(), "request");

        if (updateUserService.getErrors().isEmpty()) {
            // Create an authentication token
            Collection<GrantedAuthority> authorities = new ArrayList<>();

            for (Role role : updateUserService.findByUsername(principal.getName()).getRoles()) {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
            }

            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(
                            principal,
                            null,
                            authorities);

            // Update the security context
            SecurityContextHolder.getContext().setAuthentication(authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken("updatedUser", "password")));
        }
    }
}

// Dummy classes for the sake of completeness
class UpdateUserService {
    public void updateUser(String name, String request) {
        // Update user logic
    }

    public Collection<String> getErrors() {
        return new ArrayList<>();
    }

    public User findByUsername(String username) {
        return new User();
    }
}

class AuthenticationManager {
    public UsernamePasswordAuthenticationToken authenticate(UsernamePasswordAuthenticationToken token) {
        // Authentication logic
        return token;
    }
}

class Principal {
    public String getName() {
        return "user";
    }
}

class Role {
    private String roleName;

    public Role(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return roleName;
    }
}

class User {
    public Collection<Role> getRoles() {
        Collection<Role> roles = new ArrayList<>();
        roles.add(new Role("USER"));
        return roles;
    }
}