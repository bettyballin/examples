import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthFilter customAuthFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(customAuthFilter, UsernamePasswordAuthenticationFilter.class);

        // other configurations
    }
}