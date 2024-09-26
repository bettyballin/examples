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
    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        // configure your authentication provider here
        auth.inMemoryAuthentication()
            .withUser("user").password("{noop}password")
            .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // set up URL patterns authentication providers etc
        http.authorizeRequests()
            .antMatchers("/", "/home").permitAll()
            .anyRequest().authenticated();
    }
}