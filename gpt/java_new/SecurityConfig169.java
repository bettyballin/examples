import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig169urerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig169 extends WebSecurityConfig169urerAdapter {

    @Autowired
    private EmployeeAuthenticationProvider employeeAuthenticationProvider;
    @Autowired
    private CustomerAuthenticationProvider customerAuthenticationProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(employeeAuthenticationProvider)
            .authenticationProvider(customerAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .addFilterBefore(employeeAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
            .addFilterBefore(customerAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
            // Other configurations...
    }

    @Bean
    public EmployeeAuthenticationFilter employeeAuthenticationFilter() {
        return new EmployeeAuthenticationFilter();
    }

    @Bean
    public CustomerAuthenticationFilter customerAuthenticationFilter() {
        return new CustomerAuthenticationFilter();
    }
}