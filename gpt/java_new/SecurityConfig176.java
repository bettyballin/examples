import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig176urerAdapter;

public class SecurityConfig176 extends WebSecurityConfig176urerAdapter {

    private static final String[] publicResources = {"/", "/home", "/about"};

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
                .antMatchers(publicResources).permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/data/**").hasAnyRole("ADMIN", "DATA")
                .antMatchers("/dashboard/**").hasAnyRole("ADMIN", "DATA", "USER")
                .anyRequest().authenticated()
            .and();
    }
}