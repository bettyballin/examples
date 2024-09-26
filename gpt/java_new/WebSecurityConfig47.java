import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig47urerAdapter;

@Configuration
@EnableWebSecurity
@Order(100)
public class WebSecurityConfig47 extends WebSecurityConfig47urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Define your security configuration here
        http
            .authorizeRequests()
                .antMatchers("/public/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    // Other configurations can be added here if necessary

}