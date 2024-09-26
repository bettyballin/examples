import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // Define your custom user details service or in-memory users here

        auth.inMemoryAuthentication()
            .withUser("user")
                .password("{noop}password")
                    .roles("USER");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

      // Secure all resources under "/secured" directory
        http.authorizeRequests()
            .antMatchers("/secure/**").authenticated();

       // Enable basic authentication
        http.httpBasic().and()

        // Disable CSRF protection for simplicity
           .csrf().disable();
    }
}