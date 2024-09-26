import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class Temp532 extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService employerUserDetailsService;

    @Autowired
    private UserDetailsService employeeUserDetailsService;

    @Bean
    public DaoAuthenticationProvider employerAuthProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(employerUserDetailsService);
        return authProvider;
    }

    @Bean
    public DaoAuthenticationProvider employeeAuthProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(employeeUserDetailsService);
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(employerAuthProvider())
            .authenticationProvider(employeeAuthProvider());
    }

    public static void main(String[] args) {
        // Spring Boot application would typically start here.
        // For example, if this were a Spring Boot application:
        // SpringApplication.run(Temp532.class, args);
    }
}