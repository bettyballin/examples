import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig4urerAdapter;

@EnableWebSecurity
public class WebSecurityConfig4 extends WebSecurityConfig4urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/login.jsp").authenticated()
                .anyRequest().permitAll()
                .and()
            .httpBasic();
    }
}