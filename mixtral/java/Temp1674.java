import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1674 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Main method logic, if any
        System.out.println("Application started");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Configuration logic

        http.sessionManagement().disable();

        // Additional configuration logic
    }
}