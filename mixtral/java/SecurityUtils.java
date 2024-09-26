import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SecurityUtils {

    @Autowired
    private UserRoleService userRoleService;

    public boolean hasRequiredRole(Long userId, String requiredRole) {
        List<String> userRoles = this.userRoleService.getUserRoles(userId);

        return userRoles != null && userRoles.contains("ROLE_" + requiredRole);
    }
}

// Assuming the existence of UserRoleService
@Component
class UserRoleService {
    public List<String> getUserRoles(Long userId) {
        // Mock implementation
        return List.of("ROLE_USER", "ROLE_ADMIN");
    }
}

// Main class to test the functionality
public class Main {
    public static void main(String[] args) {
        // Simulate Spring Boot Application Context
        org.springframework.context.ApplicationContext context = 
            new org.springframework.context.annotation.AnnotationConfigApplicationContext(AppConfig.class);

        SecurityUtils securityUtils = context.getBean(SecurityUtils.class);
        boolean result = securityUtils.hasRequiredRole(1L, "ADMIN");
        System.out.println("User has required role: " + result);
    }
}

// Spring Configuration to initialize the beans
@org.springframework.context.annotation.Configuration
class AppConfig {
    @org.springframework.context.annotation.Bean
    public SecurityUtils securityUtils() {
        return new SecurityUtils();
    }

    @org.springframework.context.annotation.Bean
    public UserRoleService userRoleService() {
        return new UserRoleService();
    }
}