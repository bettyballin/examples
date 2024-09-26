import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig1urerAdapter;

@EnableWebSecurity
public class SecurityConfig1 extends WebSecurityConfig1urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .antMatcher("/api/**")
            .authorizeRequests(authorize -> authorize
                .anyRequest().hasRole("API_USER"))
            .httpBasic()
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http
            .authorizeRequests(authorize -> authorize
                .anyRequest().hasRole("USER"))
            .formLogin();
    }
}