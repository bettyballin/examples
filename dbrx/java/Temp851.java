import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp851 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        System.out.println("Spring Security Configuration");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/health", "/info").access("hasIpAddress('192.168.1.1') or hasIpAddress('192.168.1.2')")
            .anyRequest().authenticated();
    }
}