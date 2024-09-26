import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebSecurity
public class AppConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // Configure authentication
        auth.inMemoryAuthentication()
            .withUser("user").password("{noop}password").roles("USER");

        // Or use a custom UserDetailsService
        // auth.userDetailsService(customUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Configure security

        // Allow all requests
        http
            .authorizeRequests()
                .anyRequest().permitAll();

        // Or restrict access
        // http
        //     .authorizeRequests()
        //         .antMatchers("/admin/**").hasRole("ADMIN")
        //         .and()
        //     .formLogin();
    }
}