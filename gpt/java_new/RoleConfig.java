import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RoleConfig {

    public static final String ROLE = "ROLE_USER";

    @Bean(name = "roles")
    public Map<String, String> roles() {
        Map<String, String> roles = new HashMap<>();
        roles.put("userRole", ROLE);
        return roles;
    }
}

class SecuredClass {

    @PreAuthorize("hasRole(@roles['userRole'])")
    public void yourSecuredMethod() {
        // method implementation
    }
}