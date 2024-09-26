import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp1862 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        // Main method can be used to start the application context if needed
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/v1/users/**").permitAll()
                .anyRequest().authenticated();
    }
}