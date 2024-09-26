import javax.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.savedrequest.RequestCacheAwareFilter;
import org.springframework.stereotype.Component;

@Component
public class MultiAuthModeSecurityFilter extends GenericFilterBean {

    private final Filter firstSecurityFilter;
    private final Filter secondSecurityFilter;
    private final Filter thirdSecurityFilter;

    @Autowired
    public MultiAuthModeSecurityFilter(Filter firstSecurityFilter, Filter secondSecurityFilter, Filter thirdSecurityFilter) {
        this.firstSecurityFilter = firstSecurityFilter;
        this.secondSecurityFilter = secondSecurityFilter;
        this.thirdSecurityFilter = thirdSecurityFilter;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        firstSecurityFilter.doFilter(request, response, chain);
        secondSecurityFilter.doFilter(request, response, chain);
        thirdSecurityFilter.doFilter(request, response, chain);
        chain.doFilter(request, response);
    }
}

@Component
class FirstSecurityFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Filter logic here
        chain.doFilter(request, response);
    }
}

@Component
class SecondSecurityFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Filter logic here
        chain.doFilter(request, response);
    }
}

@Component
class ThirdSecurityFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Filter logic here
        chain.doFilter(request, response);
    }
}

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MultiAuthModeSecurityFilter multiAuthModeSecurityFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(multiAuthModeSecurityFilter, RequestCacheAwareFilter.class);
    }

    @Bean
    public MultiAuthModeSecurityFilter multiAuthModeSecurityFilter(FirstSecurityFilter firstSecurityFilter, SecondSecurityFilter secondSecurityFilter, ThirdSecurityFilter thirdSecurityFilter) {
        return new MultiAuthModeSecurityFilter(firstSecurityFilter, secondSecurityFilter, thirdSecurityFilter);
    }
}