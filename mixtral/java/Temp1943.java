import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class Temp1943 extends WebSecurityConfigurerAdapter {

    @Autowired
    private LDAPAuthProvider ldapAuthProvider;

    @Autowired
    private DatabaseAuthProvider databaseAuthProvider;

    @Autowired
    private EmployeeUserDetailService employeeUserDetailService;

    @Autowired
    private CustomerUserDetailService customerUserDetailService;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        // Configure LDAPAuthProvider
        ldapAuthProvider.setUserDetailsService(employeeUserDetailService);
        auth.authenticationProvider(ldapAuthProvider);

        // Configure DatabaseAuthProvider
        databaseAuthProvider.setUserDetailsService(customerUserDetailService);
        auth.authenticationProvider(databaseAuthProvider);
    }

    public static void main(String[] args) {
        // Spring Boot would typically start the application context, but for this example,
        // we will just print a message.
        System.out.println("Temp1943 application started.");
    }
}

// Mock classes for the example
class LDAPAuthProvider {
    public void setUserDetailsService(EmployeeUserDetailService service) {
        // Implementation here
    }
}

class DatabaseAuthProvider {
    public void setUserDetailsService(CustomerUserDetailService service) {
        // Implementation here
    }
}

class EmployeeUserDetailService {
    // Implementation here
}

class CustomerUserDetailService {
    // Implementation here
}