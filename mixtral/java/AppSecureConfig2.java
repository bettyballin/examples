import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class AppSecureConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Secured config
        http.authorizeRequests().anyRequest().authenticated();
    }
}

// This will be used for management port
@Configuration
public class AppUnsecuredConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Unsecure config
        http.authorizeRequests().anyRequest().permitAll();

        // Disable CSRF
        http.csrf().disable()
            .httpBasic().disable();

        // Allow all requests
        http.headers().frameOptions().sameOrigin();
    }
}