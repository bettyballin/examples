import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp889 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        // Main method body (if needed)
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                // Permit Vaadin-specific patterns
                .antMatchers("/UIDL/**").permitAll()
                .antMatchers("/HEARTBEAT/**").authenticated()
                .antMatchers("/VAADIN/**").permitAll()
                // Allow access to resources and login page
                .antMatchers("/resources/**").permitAll()
                // Block all other requests
                .anyRequest().authenticated();
    }
}