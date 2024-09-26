import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {

    String[] ignoredPaths = new String[]{
            "/robots.txt", "/error", "/login", "/doLogut", "/home", "/pageNotFound",
            "/css/**", "/js/**", "/fonts/**", "/img/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
            .antMatchers(ignoredPaths).permitAll()
            .anyRequest().authenticated()
        .and()
            .httpBasic();
    }
}