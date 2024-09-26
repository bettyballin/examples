import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig76urerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig76 {

    @Configuration
    @Order(1)
    public static class ApiWebSecurityConfig76urationAdapter extends WebSecurityConfig76urerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .antMatcher("/api/**")
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
        }
    }

    // Additional configuration classes can go here if necessary
}