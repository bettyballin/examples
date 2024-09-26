import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {
}

@Service
public class MyService {

    @RolesAllowed({"ROLE_USER"}) // Note the brackets around ROLE_USER
    public String home() {
        return "home";
    }
}