import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig109urerAdapter;

@EnableWebSecurity
public class SecurityConfig109 extends WebSecurityConfig109urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/login", "/oauth/authorize", "/img/**").permitAll()
            .anyRequest().authenticated();
    }
}