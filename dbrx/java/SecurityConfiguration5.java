import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomFilter customFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }
}

class CustomFilter extends UsernamePasswordAuthenticationFilter {
    // implementation of the custom filter
}