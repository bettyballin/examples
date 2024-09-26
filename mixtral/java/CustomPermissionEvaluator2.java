import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Set;

@Service
public class CustomPermissionEvaluator implements PermissionEvaluator {

    @Autowired
    private UserRepository userRepo;

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        String userId = ((UserDetails) authentication.getPrincipal()).getUsername();

        Project project = (Project) targetDomainObject;

        // Fetch the user and check if they have a specific role or permission for this entity
        User user = userRepo.findById(userId).orElse(null);

        if (user == null) {
            return false;
        }

        return hasPermissionForEntity(user, project, permission.toString());
    }

    private boolean hasPermissionForEntity(User user, Project project, String requiredPermission) {

        // Check if the current authenticated user is a global admin
        if (hasGlobalAdminRole()) {
            return true;
        }

        for (ProjectRole role : user.getRolesInProjects().keySet()) {
            Set<String> permissions = getPermissionsForUser(user, project);

            // Check if the current authenticated user has a specific permission in this entity
            if (permissions != null && permissions.contains(requiredPermission)) {
                return true;
            }
        }

        return false;
    }

    private boolean hasGlobalAdminRole() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Check if the current authenticated user is a global admin
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            if ("ROLE_ADMIN".equals(authority.getAuthority())) {
                return true;
            }
        }

        return false;
    }

    private Set<String> getPermissionsForUser(User user, Project project) {
        // Implementation to get permissions for the user in the given project
        return user.getRolesInProjects().get(project).getPermissions();
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        // Optionally implement this if needed
        return false;
    }
}

// Dummy implementations for UserRepository, User, Project, and ProjectRole for completeness
interface UserRepository {
    User findById(String userId);
}

class User {
    private String id;
    private Map<Project, ProjectRole> rolesInProjects;

    public String getId() {
        return id;
    }

    public Map<Project, ProjectRole> getRolesInProjects() {
        return rolesInProjects;
    }
}

class Project {
    // Project implementation
}

class ProjectRole {
    private Set<String> permissions;

    public Set<String> getPermissions() {
        return permissions;
    }
}