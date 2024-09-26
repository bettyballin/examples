import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthProvider authProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JwtAuthenticationFilter filter = new JwtAuthenticationFilter();

        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

        // Other configurations

        http
            .authorizeRequests()
                .anyRequest().authenticated();
    }
}

class CustomAuthProvider {
    // Custom authentication provider implementation
}

class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    // JWT authentication filter implementation
}