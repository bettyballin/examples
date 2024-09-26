import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import javax.servlet.Filter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // ...

        RequestMatcher matcher = new AntPathRequestMatcher("/session");

        Filter filter = new SeessonObjectRespond();

        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>(filter);

        registrationBean.setEnabled(false);

        http
            .addFilterBefore(filter, AnonymousAuthenticationFilter.class)
            .requestMatcher(matcher);
    }
}

class SeessonObjectRespond implements Filter {
    // Implement the required methods for the filter here
    @Override
    public void doFilter(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.FilterChain chain)
            throws java.io.IOException, javax.servlet.ServletException {
        // Filter logic
    }

    @Override
    public void init(javax.servlet.FilterConfig filterConfig) throws javax.servlet.ServletException {
        // Initialization logic
    }

    @Override
    public void destroy() {
        // Cleanup logic
    }
}