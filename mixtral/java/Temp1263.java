import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp1263 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Application entry point
        System.out.println("Temp1263 application started.");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .oauth2Login()
            .and()
            .authorizeRequests()
                .antMatchers("/", "/login**").permitAll()
                .anyRequest().authenticated();
    }
}