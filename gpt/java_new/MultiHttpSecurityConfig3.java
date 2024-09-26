import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class MultiHttpSecurityConfig3 {

    @Configuration
    @Order(1) // Order for the API configuration, with higher precedence
    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .antMatcher("/api/**") // Apply this configuration to API paths only
                .authorizeRequests()
                    .anyRequest().authenticated()
                .and()
                .httpBasic(); // For example, configure HTTP Basic for the API
        }
    }

    @Configuration
    @Order(2) // Order for the form login configuration
    public static class FormLoginWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .authorizeRequests()
                    .anyRequest().authenticated()
                .and()
                .formLogin() // Configure form login
                .and()
                .httpBasic()
                .and()
                .csrf().disable(); // Form login might not need CSRF protection
        }
    }
}