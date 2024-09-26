import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig152urerAdapter;

@EnableWebSecurity
public class SecurityConfig152 extends WebSecurityConfig152urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/api/v1/admin_role/*").hasAuthority("ROLE_ADMIN")
            .antMatchers("/api/v1/user_role/*").hasAuthority("ROLE_USER")
            .anyRequest().authenticated();
    }
}