import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

@SpringBootApplication
public class Temp2413 {

    public static void main(String[] args) {
        SpringApplication.run(Temp2413.class, args);
    }
}

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/your-endpoint").authenticated()
                .and()
            .formLogin()
                .and()
            .httpBasic();
    }
}

@RestController
class YourController {

    @GetMapping("/your-endpoint")
    @PreAuthorize("hasRole('ROLE_ADMIN') ? 'adminValue' : 'userValue'")
    public String getData() {
        // Your logic here
        return "Data";
    }
}