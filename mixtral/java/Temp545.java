import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp545 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        System.out.println("Application Started");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // First handle exceptions
        http.exceptionHandling().accessDeniedPage("/403");

        // Then set up authentication and authorization
        http.authorizeRequests()
            .antMatchers("/api/private/**", "/app/**")
            .authenticated();

        // Disable CSRF protection
        http.csrf().disable();

        // Set logout success URL
        http.logout().logoutSuccessUrl("/");
    }
}