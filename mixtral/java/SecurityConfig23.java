import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // ...

        http.formLogin()
            .loginPage("/custom-login")  // URL path for your custom login page
            .defaultSuccessUrl("/home", true);

        // ...

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
         // Your existing code
     }
}