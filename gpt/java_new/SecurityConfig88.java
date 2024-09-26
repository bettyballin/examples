import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig88urerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig88 {

    @Configuration
    @Order(1)
    public static class ApiWebSecurityConfig88urationAdapter extends WebSecurityConfig88urerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .antMatcher("/api/v1/**")
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .oauth2ResourceServer().jwt();
        }
    }

    @Configuration
    public static class FormLoginWebSecurityConfig88urerAdapter extends WebSecurityConfig88urerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .authorizeRequests()
                .antMatchers("/account/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/login");
        }
    }
}