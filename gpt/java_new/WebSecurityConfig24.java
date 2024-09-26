import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig24urerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig24uration;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

@EnableWebSecurity
@Order(SecurityProperties.BASIC_AUTH_ORDER - 1)
public class WebSecurityConfig24 extends WebSecurityConfig24urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .httpBasic()
                .and()
            .authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated();
    }
}