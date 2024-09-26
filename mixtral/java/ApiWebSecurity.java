import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableWebSecurity
public class SecurityConfig {

    @Configuration
    @Order(1)
    public static class ApiWebSecurity extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            // Configure HttpSecurity for API endpoints
            http.antMatcher("/api/**")
                .authorizeRequests()
                    .anyRequest().authenticated()
                .and()
                    .httpBasic(); // Example of additional configuration
        }
    }

    @Configuration
    @Order(2)
    public static class WebSecurity extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            // Configure HttpSecurity for web endpoints
            http.antMatcher("/**")
                .authorizeRequests()
                    .anyRequest().authenticated()
                .and()
                    .formLogin(); // Example of additional configuration
        }
    }
}