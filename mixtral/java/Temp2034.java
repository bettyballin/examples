import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Allow unauthenticated requests to /actuator/** and /configprops endpoints
        http.authorizeRequests().antMatchers("/actuator/**", "/configprops").permitAll();

        // Secure the remaining endpoints with HTTP Basic authentication
        http
            .csrf()
                .disable()
            .httpBasic()
                .and()
            .authorizeRequests()
                .antMatchers("/**")
                    .authenticated();
    }
}