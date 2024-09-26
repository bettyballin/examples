import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp3005 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Spring Boot application would normally be started here
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
            .defaultSuccessUrl("/homeLogged", true)
            .permitAll();
    }
}