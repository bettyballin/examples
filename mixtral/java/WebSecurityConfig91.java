import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.http.HttpMethod;

@Configuration
@EnableWebSecurity(debug = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Configure open access for ZooKeeper response
        http.antMatcher("/inner/service/event/bus").authorizeRequests().anyRequest().anonymous();

        // Configure authenticated access for other services
        http.antMatcher("/inner/service/**")
            .authorizeRequests()
                .anyRequest().hasRole("USER");

        // Disable CSRF protection
        http.csrf().disable();

        // Configure form login and logout
        http.formLogin()
                .and()
            .logout()
                .and()
            .httpBasic();
    }
}