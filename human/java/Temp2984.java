import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
public class Temp2984 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(Temp2984.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authenticationProvider(authenticationProvider())
            .authorizeRequests()
            .antMatchers("/api/v1/specific").hasRole("ONLY_FOR_THIS_ENDPOINT")
            .antMatchers("/api/v1/**").hasRole("ADMIN")
            .anyRequest().authenticated()
            .and()
            .formLogin();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user1").password("{noop}password").roles("ONLY_FOR_THIS_ENDPOINT").build());
        manager.createUser(User.withUsername("admin").password("{noop}password").roles("ADMIN").build());
        return manager;
    }

    @Bean
    public org.springframework.security.authentication.AuthenticationProvider authenticationProvider() {
        return new org.springframework.security.authentication.dao.DaoAuthenticationProvider() {{
            setUserDetailsService(userDetailsService());
        }};
    }
}