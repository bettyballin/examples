import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfiguration26 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // other configuration...
            .authorizeRequests()
                .antMatchers("/signup", "/user/signup").permitAll()
                .anyRequest().authenticated();
            // other configuration...
    }
}