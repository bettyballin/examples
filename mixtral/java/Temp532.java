import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp532 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // main method content
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // ...

        http.formLogin()
            .loginPage("/login")
            .permitAll();

        // Removed failureHandler line
        // .failureHandler(customAuthenticationHandler);

        // ...
    }
}