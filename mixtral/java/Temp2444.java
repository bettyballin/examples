import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp2444 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Main method content (if needed)
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                // Allow access for all users
                .antMatchers("/", "/home").permitAll()
                // Require admin role to access these pages
                .antMatchers("/editincident", "/editaaccident", "/editrequest").hasRole("ADMIN");
    }
}