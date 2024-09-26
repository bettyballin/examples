import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig29urerAdapter;

@EnableWebSecurity
public class WebSecurityConfig29 extends WebSecurityConfig29urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/**/*.html").authenticated() // Require authentication for .html files
                .anyRequest().permitAll() // Allow all other requests without authentication
            .and()
            .formLogin()
                .loginPage("/login").permitAll() // Provide a custom login page
            .and()
            .logout().permitAll(); // Allow logout for all users
    }
}