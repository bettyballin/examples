import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthenticationProvider authProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .httpBasic();

        // Disable CSRF protection for stateless REST API
        http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
          .authenticationProvider(authProvider);

        // If you have multiple authentication providers use the following:
//      auth
//         .authenticationProvider(daoAuthProvider())
//         .authenticationProvider(ldapAuthProvider());
    }

    // Define your CustomAuthenticationProvider class or import it if it's in another file
    public static class CustomAuthenticationProvider { 
        // Implementation of CustomAuthenticationProvider
    }
}