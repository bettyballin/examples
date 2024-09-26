import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp415 extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/make/private").authenticated()
            .anyRequest().permitAll();
    }

    public static void main(String[] args) {
        // Spring Boot application would typically start here, but for this example, 
        // the security configuration is automatically loaded by Spring Security.
    }
}