import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1145 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        // Main method, typically used to run the application
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
            .usernameParameter("user")
            .passwordParameter("password")
            .loginProcessingUrl("/api/authorization")  // Change the login processing URL.
            .permitAll();
    }
}