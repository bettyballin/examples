import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig170urerAdapter;
import org.springframework.http.HttpMethod;

@Configuration
@EnableWebSecurity
public class SecurityConfig170 extends WebSecurityConfig170urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/adduser").permitAll()
                .anyRequest().authenticated()
                .and()
            .httpBasic();
    }
}