import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1697 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        // Main method body can be empty as this is a configuration class
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .x509()
                .and()
                    // Disable CSRF Protection
                    .csrf().disable();
    }

    // Or to disable it for specific URL patterns:
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .x509()
                .and()
                    // Disable CSRF Protection only on /customers
                    .csrf().ignoringAntMatchers("/customers/**");
    }
}