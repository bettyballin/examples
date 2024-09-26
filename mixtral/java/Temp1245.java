import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1245 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Main method logic here
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // ... other configurations
            .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
                .logoutUrl("/perform_logout");
    }
}