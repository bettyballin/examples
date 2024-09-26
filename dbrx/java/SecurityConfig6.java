import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsFilter customUserDetailsFilter;

    // other configurations

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(customUserDetailsFilter, UsernamePasswordAuthenticationFilter.class);
        http.authorizeRequests().anyRequest().permitAll(); // Add this line
    }
}