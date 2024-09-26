import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfig1uration;
import org.springframework.security.access.prepost.PreAuthorize;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MethodSecurityConfig1 extends GlobalMethodSecurityConfig1uration {
    // ...
}

class YourClass {
    @PreAuthorize("isAuthenticated()")
    public void yourSecuredMethod() {
        // ...
    }
}