import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig50urerAdapter;

@EnableWebSecurity
public class SecurityConfig50 extends WebSecurityConfig50urerAdapter {

    private static final String ROLE_CLIENT = "CLIENT";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/gpns/rest/gpnfeedback/**").hasRole(ROLE_CLIENT)
            .antMatchers("/gpns/rest/sendgpn/**").permitAll()
            .anyRequest().authenticated()
            .and().httpBasic();
    }
}