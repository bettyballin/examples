import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig28urerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig28 extends WebSecurityConfig28urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/images/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/custom-login")
                .loginProcessingUrl("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }
}