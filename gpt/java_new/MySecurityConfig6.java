import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class MySecurityConfig6 extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // ... your other http configuration
        
        http.anonymous().authorities("ROLE_ANONYMOUS");
        
        // ... continue with other configurations if necessary
    }
}