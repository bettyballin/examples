import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp1424 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        // Application entry point
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors()
                .and().csrf().disable()
                .formLogin().loginPage("/rest/auth/login")
                   .permitAll();
    }
}