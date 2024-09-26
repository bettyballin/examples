import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig37urerAdapter;

@EnableWebSecurity
public class WebSecurityConfig37 extends WebSecurityConfig37urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/view/**").hasAnyRole("ADMIN", "GUEST")
                .anyRequest().authenticated()
            .and()
            // other configurations ...
            ;
        // other method calls can be chained here if needed
    }

    // other methods ...
}