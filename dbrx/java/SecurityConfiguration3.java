import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    // Your security configuration methods here...

    @Bean
    public MethodSecurityService securityService() {
        return new MethodSecurityServiceImpl();
    }

    private static final String LDAP_USER_ROLE = "LDAP_USER_ROLE";

}

interface MethodSecurityService {
    // Define methods for the service
    void someMethod();
}

class MethodSecurityServiceImpl implements MethodSecurityService {
    // Implement methods for the service
    @Override
    public void someMethod() {
        // do something
    }
}