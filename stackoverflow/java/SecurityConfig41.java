import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig41urerAdapter;

@EnableWebSecurity
public class SecurityConfig41 extends WebSecurityConfig41urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/uri/**").hasAuthority("SOME_ROLE")
            .anyRequest().authenticated();
    }
}