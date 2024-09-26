import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig38urerAdapter;

public class SecurityConfig38 extends WebSecurityConfig38urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // other configurations
            .authorizeRequests()
                .antMatchers("/pages/project/create/**", "/pages/project/edit/**")
                .hasRole("USER");
                // other secured pages
            // further configurations
    }
}