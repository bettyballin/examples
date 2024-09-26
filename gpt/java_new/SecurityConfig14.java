public enum UserPermission {
    READ_PRIVILEGES, WRITE_PRIVILEGES;
    // define permissions
}

public enum UserRole {
    ADMIN, USER;
    // define roles with associated permissions
}

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig14urerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig14 extends WebSecurityConfig14urerAdapter {
    // Implement security configuration methods if needed
}