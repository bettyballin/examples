import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig61urerAdapter;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig61 extends WebSecurityConfig61urerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // ... your authentication configuration
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // ... your http configuration
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        // Provide the default AuthenticationManager as a bean
        return super.authenticationManagerBean();
    }

    // ... other configurations such as userDetailsServiceBean, etc.
}