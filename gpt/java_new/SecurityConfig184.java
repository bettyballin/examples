import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig184urerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig184 {

    @Configuration
    @Order(1)
    public static class PublicWebSecurityConfig184urationAdapter extends WebSecurityConfig184urerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .antMatcher("/public/**")
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/public/**").permitAll()
                .anyRequest().authenticated();
        }
    }

    // Other security configurations can be added here as nested static classes
}