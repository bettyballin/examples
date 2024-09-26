import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp967 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                // other authorization rules
                .antMatchers("/public/**").permitAll()
                .anyRequest().authenticated()
            .and()
            .requiresChannel()
                .anyRequest().requiresSecure();
    }

    public static void main(String[] args) {
        // Main method can be used to launch Spring Boot application if needed
    }
}