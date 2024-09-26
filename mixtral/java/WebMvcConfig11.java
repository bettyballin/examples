import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Redirect /foo/* to in_development.html
        http
            .antMatcher("/foo/**")
                .authorizeRequests()
                    .anyRequest().permitAll();

        super.configure(http);

        http
            .exceptionHandling()
                .accessDeniedPage("/in_development_page");
    }
}