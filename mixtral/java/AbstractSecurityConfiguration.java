import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public abstract class AbstractSecurityConfiguration extends WebSecurityConfigurerAdapter {
    // Common configurations here
}

@Configuration
@Order(1)
public class RestApiSecurityConfiguration extends AbstractSecurityConfiguration {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);

        http
            .antMatcher("/api/**")
            // Disable CSRF for REST API
            .csrf().disable()
            // Configure HTTP Basic Authentication
            .authorizeRequests()
            .anyRequest().authenticated();
    }
}

@Configuration
@Order(2)
public class WebSecurityConfiguration extends AbstractSecurityConfiguration {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);

        // Your existing configuration for web application
        http
            .authorizeRequests()
            // Define your web security configurations here
            // Example: .antMatchers("/").permitAll()
            .anyRequest().authenticated()
            .and()
            // Disable CSRF
            .csrf().disable();
    }
}