import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig123urerAdapter;

public class SecurityConfig123 extends WebSecurityConfig123urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
            .authorizeRequests()
                .antMatchers("/private").hasRole("ADMIN")
                .antMatchers("/private/**").hasRole("ADMIN")
                .antMatchers("/**").permitAll()
                .and()
            .httpBasic();
    }
}