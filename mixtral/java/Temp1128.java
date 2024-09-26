import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp1128 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        System.out.println("Spring Security Configuration");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Your security configuration here
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and().formLogin();
    }
}