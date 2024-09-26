import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Order(1)
    public static class MVCFormLoginSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .antMatcher("/users/**")
                    .csrf()
                        .disable()
                    .authorizeRequests()
                        .anyRequest().authenticated();
        }
    }

    @Order(2)
    public static class APIHttpBasicSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .antMatcher("/api/v1/**")
                    .authorizeRequests()
                        .anyRequest().authenticated()
                    .and()
                    .httpBasic();
        }
    }
}