import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Disable caching for all requests
        http.headers().cacheControl().disable();

        // Or customize the cache control headers
        http.headers()
            .addHeaderWriter((request, response) ->
                response.setHeader("Cache-Control", "max-age=600"));
    }
}