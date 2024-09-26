import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MyController {

    @Autowired
    private UserRoleRepository userRoleRepository; // Inject the UserRoleRepository

    @GetMapping("/admin-only")
    @RolesAllowed("ROLE_ADMIN")
    public String getAdminOnly() {
        // Only admins can see this page
        return "You're an admin!";
    }

    @GetMapping("/user-only")
    @RolesAllowed("ROLE_USER")
    public String getUserOnly() {
        // Only users can see this page
        return "You're a user!";
    }

    @Autowired
    private UserDetailsService userDetailsService; // Inject the UserDetailsService

    @GetMapping("/current-user")
    public String getCurrentUser() {
        // Fetch the current user's role(s) from the database
        User user = (User) userDetailsService.loadUserByUsername("your_username");
        List<String> roles = user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return "Your roles: " + String.join(", ", roles);
    }
}