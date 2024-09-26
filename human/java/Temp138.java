import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp138 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Your main application logic
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Your security configuration
        http
            .authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .formLogin().permitAll();
    }
}