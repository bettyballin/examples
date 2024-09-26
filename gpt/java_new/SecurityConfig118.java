import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig118urerAdapter;

@EnableWebSecurity
public class SecurityConfig118 extends WebSecurityConfig118urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/health", "/info").permitAll()
                .antMatchers("/**").access("hasIpAddress('X.X.X.X') or hasIpAddress('Y.Y.Y.Y')")
                .anyRequest().authenticated()
            .and();
    }
}