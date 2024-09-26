import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class BrowserClientSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Enable CSRF protection for specific URL patterns
        http.csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("/api/browser/**"))
            .and()
                .authorizeRequests()
                .anyRequest().authenticated();
    }
}