import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.context.annotation.Bean;

@EnableWebSecurity
public class Temp2983 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authenticationProvider(authenticationProvider())
            .authorizeRequests()
            .antMatchers("/api/v1/specific").hasRole("ONLY_FOR_THIS_ENDPOINT")
            .antMatchers("/api/v1/**").hasRole("ADMIN")
            .and()
            .formLogin();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("ADMIN").build());
        manager.createUser(User.withDefaultPasswordEncoder().username("endpointUser").password("password").roles("ONLY_FOR_THIS_ENDPOINT").build());
        return manager;
    }

    @Bean
    public CustomAuthenticationProvider authenticationProvider() {
        return new CustomAuthenticationProvider();
    }

    public static void main(String[] args) {
        // Spring Boot would automatically run the application and load the security configuration
    }
}

class CustomAuthenticationProvider extends org.springframework.security.authentication.dao.DaoAuthenticationProvider {
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return new Temp2983().userDetailsService();
    }
}