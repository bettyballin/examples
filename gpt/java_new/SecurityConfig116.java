import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig116urerAdapter;

public class SecurityConfig116 extends WebSecurityConfig116urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/myPanel").authenticated()
                .and()
            .formLogin()
                .and()
            .logout();
    }
}