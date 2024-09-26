import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.example")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
}

@Component
public class RoleProvider {
    @Autowired
    private Environment environment;

    public String getRole() {
        return "SOME_" + environment.getActiveProfiles()[0] + "_ROLE";
    }
}

@Service
public class SomeService {
    @Autowired
    private RoleProvider roleProvider;

    @PreAuthorize("hasRole(@roleProvider.getRole())")
    public void someMethod() {
        // Your code here
    }
}