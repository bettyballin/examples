import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1661 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Entry point for the application
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/images/**").permitAll()
            .antMatchers("/css/**").permitAll()
            .anyRequest().authenticated(); // Ensure other requests are authenticated
    }
}