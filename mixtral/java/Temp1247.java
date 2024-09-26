import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1247 extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .logout().disable()
            .and()
            .csrf().disable()
            .logout();
    }

    public static void main(String[] args) {
        // Spring Boot should be configured to run this code.
    }
}