import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp1875 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Spring Boot application entry point would go here
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // ... other configurations

            .authorizeRequests()
                .antMatchers("/my-path/**").authenticated()
                
            .and()
            .httpBasic();
    }
}