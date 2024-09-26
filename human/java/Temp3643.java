import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp3643 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Main method can be used to start application context if needed
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
            .antMatchers("/api/v0/auth/login");
    }
}