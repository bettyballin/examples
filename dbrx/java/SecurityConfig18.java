import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .requestMatcher(new AntPathRequestMatcher("/secure/**"))
            .authorizeRequests()
                .anyRequest().authenticated()
            .and()
                .formLogin();

        http
            .requestMatcher(new AntPathRequestMatcher("/api/**"))
            .authorizeRequests()
                .anyRequest().hasRole("API_USER")
            .and()
                .httpBasic();
    }

}