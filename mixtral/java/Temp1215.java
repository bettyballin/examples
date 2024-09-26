import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp1215 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                // allow everyone to register an account; /console is just for testing
                .antMatchers("/register", "/console/**").permitAll()
                .anyRequest().denyAll();
    }

    public static void main(String[] args) {
        System.out.println("Security configuration loaded.");
    }
}