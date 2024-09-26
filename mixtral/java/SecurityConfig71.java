import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                // permit all for static resources
                .antMatchers("/css/**", "/js/**", "/img/**").permitAll()
                // allow access to specific pages without authentication
                .antMatchers("/", "/home", "/link").permitAll()
                // require admin role for /admin
                .antMatchers("/admin**").hasRole("ADMIN")
            // any other request requires authenticated user
            .anyRequest().authenticated()
            .and()
            // configure login and logout
            .formLogin().loginPage("/login").permitAll()
            .and()
            .logout().permitAll();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            // in-memory authentication
            .inMemoryAuthentication()
            .withUser("admin")
            .password("{noop}admin").roles("USER", "ADMIN")
            .and()
            .withUser("user")
            .password("{noop}user").roles("USER");
    }
}