import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Other configurations

        http
            .authorizeRequests()
                .antMatchers("/your-endpoint/**").hasRole("USER")
                .and().httpBasic();

        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry =
            http.authorizeRequests()
                // permitAll for POST
                .antMatchers(HttpMethod.POST, "/your-endpoint/**").permitAll();

        // Other configurations
    }
}