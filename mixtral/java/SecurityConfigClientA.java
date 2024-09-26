import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfigClientA extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Allow access to "/health" endpoint without authentication
        http.antMatcher("/clientA/**")
            .authorizeRequests()
                .mvcMatchers("/health").permitAll();
    }
}

@Configuration
public class SecurityConfigClientB extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Require JWT authentication for all endpoints
        http.antMatcher("/clientB/**")
            .authorizeRequests()
                .anyRequest().authenticated();

        // Add your custom JWT filter here
    }
}