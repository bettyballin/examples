import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.Serializable;

// Renamed interface to CustomPermissionEvaluator
public interface CustomPermissionEvaluator {
    boolean hasPermission(Authentication authentication, Object targetDomainObject, String permission);
    boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, String permission);
}

@Service("projectService")
@org.springframework.security.access.prepost.PreAuthorize("@permissionEvaluator.hasPermission(authentication, #request, 'create_project')")
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private CustomPermissionEvaluator projectPermissionEvaluator;

    public void create(ProjectEditRequest request) {
        // ...
    }
}

@Component("permissionEvaluator")
public class ProjectPermissionEvaluator implements CustomPermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, String permission) {
        if (authentication == null || !(targetDomainObject instanceof ProjectEditRequest)) {
            return false;
        }

        User user = (User) authentication.getPrincipal();
        // Assuming ProjectEditRequest has a method to get Project instance
        Long projectId = ((ProjectEditRequest) targetDomainObject).getProjectId();

        // Check the permissions based on your logic
        boolean hasPermission = checkPermissions(user, permission, projectId);

        return hasPermission;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, String permission) {
        // Implementation if needed
        return false;
    }

    private boolean checkPermissions(User user, String permission, Long projectId) {
        // Implement your permission check logic here
        return true; // Just for example
    }
}

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    @Override
    protected org.springframework.security.access.expression.method.MethodSecurityExpressionHandler createExpressionHandler() {
        DefaultMethodSecurityExpressionHandler expressionHandler =
                new DefaultMethodSecurityExpressionHandler();
        expressionHandler.setPermissionEvaluator(new ProjectPermissionEvaluator());
        return expressionHandler;
    }
}

// Dummy classes to make the code compile
interface ProjectService {
    void create(ProjectEditRequest request);
}

class ProjectEditRequest {
    private Long projectId;
    public Long getProjectId() { return projectId; }
    // Other fields and methods
}

class Project {
    private Long id;
    public Long getId() { return id; }
}