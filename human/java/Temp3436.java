import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp3436 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Main method can be empty or used for other purposes
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.csrf().disable()
           .authorizeRequests()
           .anyRequest().hasRole("admin");
    }
}