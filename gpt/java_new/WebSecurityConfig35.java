import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig35urerAdapter;

@EnableWebSecurity
public class WebSecurityConfig35 extends WebSecurityConfig35urerAdapter {

    private static final String API_ROLE = "API_USER"; // Assuming a role exists with name "API_USER"

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .antMatcher("/services/**")
            .authorizeRequests()
            .anyRequest().hasRole(API_ROLE)
            .and()
            .httpBasic()
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .csrf().disable();
    }
}