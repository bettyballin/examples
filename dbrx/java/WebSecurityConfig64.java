import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(WebSecurity web) throws Exception {
        // Ignore websocket endpoints from Spring Security filter chain
        web.ignoring().antMatchers("/your-websocket-endpoint/**");
    }

    // Your other security configurations here...
}


Note: I changed `public void configure(WebSecurity web)` to `protected void configure(WebSecurity web)`. The method in `WebSecurityConfigurerAdapter` is protected.