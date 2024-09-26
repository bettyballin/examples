import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig39urerAdapter;

@EnableWebSecurity
public class SecurityConfig39 extends WebSecurityConfig39urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .antMatcher("/app/ws/**")
            .authorizeRequests(authorizeRequests ->
                authorizeRequests.anyRequest().hasRole("WEBSERVICE"))
            .httpBasic();

        http
            .authorizeRequests(authorizeRequests ->
                authorizeRequests.anyRequest().authenticated())
            .formLogin();
    }
}