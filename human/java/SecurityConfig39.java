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
    public void configureGlobal(AuthenticationManagerBuilder auth)
        throws Exception {
        auth
           .inMemoryAuthentication()
               .withUser("admin")
                   .password("{noop}admin") // {noop} is used for plain text password, not recommended for production
                   .roles("ADMIN")
                   .and()
               .withUser("user")
                   .password("{noop}user") // {noop} is used for plain text password, not recommended for production
                   .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")
                .and()
             .formLogin()
                .defaultSuccessUrl("/default")
                .loginPage("/")
                .failureUrl("/")
                .and()
            .logout()
                .logoutSuccessUrl("/")
                .and()
            // It is generally BAD to disable CSRF protection!
            .csrf().disable();
     }
}