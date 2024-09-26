import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Allow all requests except those starting with "/private"
        http.authorizeRequests()
                .antMatchers("/private/**").hasAuthority("ADMIN")
            .and().httpBasic();

        // Permit any other request
        http.authorizeRequests().anyRequest().permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
         auth
             .inMemoryAuthentication()
                 .withUser("user")
                     .password("{noop}pass")
                     .roles("ADMIN");

        // You can add more users here if needed
    }

}