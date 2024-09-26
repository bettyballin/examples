import org.springframework.context.annotation.Bean;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;

public class SecurityConfig24 {

    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy("ROLE_ADMIN > ROLE_STAFF and ROLE_ADMIN > ROLE_DEVELOPER and ROLE_STAFF > ROLE_USER and ROLE_DEVELOPER > ROLE_USER");
        return roleHierarchy;
    }
}