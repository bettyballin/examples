import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.authentication.LdapAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   @Autowired
   private LdapAuthenticationProvider ldapAuth;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Enable Basic Authentication
        http.httpBasic().and()
            .authorizeRequests()
            .anyRequest().authenticated();
    }
}