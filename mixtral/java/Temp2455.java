import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp2455 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        System.out.println("Temp2455 Application Started");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .httpBasic();

        // Invalidate the current user's HttpSession when a new login attempt occurs
        http.sessionManagement().invalidateHttpSession(true);
    }
}