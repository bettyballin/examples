import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig7urerAdapter;
import org.springframework.security.ldap.authentication.LDAPAuthenticationProvider;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import com.example.security.OTPAuthenticationProvider;

@EnableWebSecurity
public class WebSecurityConfig7 extends WebSecurityConfig7urerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(new LDAPAuthenticationProvider())
            .authenticationProvider(new OTPAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // disable csrf
        http.csrf().disable();

        // setup security
        http.authorizeRequests()
            .anyRequest().fullyAuthenticated()
            .and()
            .httpBasic();
    }
}