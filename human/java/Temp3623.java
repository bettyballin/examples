import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp3623 extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(a -> a.antMatchers("...").permitAll())
            .csrf(csrf -> csrf.ignoringAntMatchers("..."));
    }

    public static void main(String[] args) {
        System.out.println("Spring Security Configuration Loaded");
    }
}