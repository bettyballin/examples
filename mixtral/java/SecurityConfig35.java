import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void globalConfig(AuthenticationManagerBuilder auth, DataSource dataSource) throws Exception {

        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .passwordEncoder(passwordEncoder())
            .usersByUsernameQuery("select username as principal, password as credentials, true from users where username = ?")
            .authoritiesByUsernameQuery("select u.username as principal, 'ROLE_' || r.role as role from users u, roles r where"
                    + " u.roles_id = r.id and username = ?");

        //           .rolePrefix("role_");
    }

    // Define a password encoder bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Other security configurations...
}

@RestController
public class ServerService {

    // Other service methods...

    @Secured({"ROLE_root", "ROLE_admin"})
    @RequestMapping(value="getServers", method = RequestMethod.GET)
    public List getServers(@RequestParam String st) {
        // Implementation for fetching servers...
        return null;
    }
}