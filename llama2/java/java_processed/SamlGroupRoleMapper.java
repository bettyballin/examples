import org.springframework.security.core.authority.mapping.RoleMapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SamlGroupRoleMapper implements RoleMapper {
    private final UserDetailsService userDetailsService;

    public SamlGroupRoleMapper(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public List<String> mapGroupsToRoles(List<String> groups, String username) {
        // Iterate over the incoming SAML group attributes
        for (String group : groups) {
            // Use the UserDetailsService to retrieve the user's details
            User user = (User) userDetailsService.loadUserByUsername(username);

            // Check if the user belongs to the current group
            if (user.getAuthorities().stream().anyMatch(authority -> authority.getAuthority().equals(group))) {
                // If so add the corresponding role to the list of roles
                List<String> roles = new ArrayList<>();
                roles.add("ROLE_" + group);
                return roles;
            }
        }

        // Return an empty list if no matching group was found
        return Collections.emptyList();
    }

    @Override
    public List<String> mapRolesToGroups(List<String> roles, String username) {
        // Not needed for this use case
        return Collections.emptyList();
    }
}