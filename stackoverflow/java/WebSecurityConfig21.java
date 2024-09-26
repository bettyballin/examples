import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig21urerAdapter;

@EnableWebSecurity
public class WebSecurityConfig21 extends WebSecurityConfig21urerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/**").hasRole("USER")
                .and()
                .formLogin().loginPage("/login").permitAll();
    }
}