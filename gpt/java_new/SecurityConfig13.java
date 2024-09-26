import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig13urerAdapter;

@EnableWebSecurity
public class SecurityConfig13 extends WebSecurityConfig13urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
            .and()
            .csrf().disable()
            .formLogin().disable()
            .httpBasic().disable();
    }
}