import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp2178 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        System.out.println("Spring Security Example");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Configure security settings here if needed
        http
            .authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .formLogin().and()
            .httpBasic();
    }
}