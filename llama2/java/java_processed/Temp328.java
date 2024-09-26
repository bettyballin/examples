import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp328 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Spring Boot application would typically start here, but for the purpose of this example, we'll leave it empty.
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.authorizeRequests()
                .antMatchers("/entity/**").permitAll();
    }
}