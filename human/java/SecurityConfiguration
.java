import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Your configuration

        // Add the custom filter
        // see https://docs.spring.io/spring-security/site/docs/5.2.1.RELEASE/reference/htmlsingle/#filter-stack
        // you can name every provided filter or any specified that is included in the filter chain
        http.addFilterAfter(new SessionValidationFilter(), BasicAuthenticationFilter.class);
    }
}

class SessionValidationFilter extends BasicAuthenticationFilter {
    public SessionValidationFilter() {
        super(null);
    }

    // Your filter logic
}