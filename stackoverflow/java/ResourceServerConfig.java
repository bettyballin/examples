import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private static final String[] ignoredPaths = {
            "/robots.txt", "/error", "/login", "/doLogout", "/home", "/pageNotFound",
            "/css/**", "/js/**", "/fonts/**", "/img/**" // Removed the ellipsis '...'
    };

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(ignoredPaths).permitAll()
                .anyRequest().authenticated()
            .and()
                .httpBasic();
    }
}