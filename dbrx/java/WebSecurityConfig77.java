import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // v1 API with Basic authentication
        http.antMatcher("/api/v1/**")
            .authorizeRequests()
            .anyRequest().authenticated()
            .and().httpBasic();

        // v2 API with Token-based authentication
        http.antMatcher("/api/v2/**")
            .authorizeRequests()
            .anyRequest().hasRole("TOKEN_AUTHENTICATED_USER");

        // all other requests
        http.antMatcher("/**")
            .authorizeRequests()
            .anyRequest().permitAll();
    }
}