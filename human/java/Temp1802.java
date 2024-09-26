import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1802 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Entry point for the Java application
        System.out.println("Application started");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement()
            .maximumSessions(1)
            .and()
            .invalidSessionUrl("/expired");
    }
}