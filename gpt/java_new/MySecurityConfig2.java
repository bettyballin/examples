import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class MySecurityConfig2 extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // ... your other configurations
            
            // Disable CSRF for a specific path
            .csrf()
                .ignoringAntMatchers("/public/rest/status")
                .and();
            
            // ... your other configurations
    }
}