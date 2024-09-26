import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() throws Exception {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        // Add users to the manager
        // manager.createUser(User.withUsername("user").password("{noop}password").roles("USER").build());
        return manager;
    }

    @Order(1)
    static class ApiV1SecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .antMatcher("/api/v1/**")
                    .authorizeRequests()
                        .anyRequest().authenticated()
                .and()
                    .httpBasic(); // Add basic authentication
        }
    }

    @Order(2)
    static class ApiTestSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .antMatcher("/api/test/**")
                    .authorizeRequests()
                        .anyRequest().authenticated()
                .and()
                    .httpBasic(); // Add basic authentication
        }
    }
}