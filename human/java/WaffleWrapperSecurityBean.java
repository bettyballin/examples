import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.authentication.AuthenticationEntryPoint;
import org.springframework.web.filter.GenericFilterBean;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.IOException;

// Configuration class
public class SecurityConfig {
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/access-denied")
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/**")
                .authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(negotiateSecurityFilterEntryPoint())
                .accessDeniedPage("/access-denied")
                .and()
                .addFilterBefore(waffleNegotiateSecurityFilter(), BasicAuthenticationFilter.class);
    }

    private AuthenticationEntryPoint negotiateSecurityFilterEntryPoint() {
        // Implement your AuthenticationEntryPoint here
        return null;
    }

    private GenericFilterBean waffleNegotiateSecurityFilter() {
        return new WaffleWrapperSecurityBean(new GenericFilterBean() {
            @Override
            public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
                chain.doFilter(request, response);
            }
        });
    }
}

// Filter class
@WebFilter("/*")
public class WaffleWrapperSecurityBean extends GenericFilterBean {

    @NotNull
    private final GenericFilterBean wrappedFilter;

    public WaffleWrapperSecurityBean(GenericFilterBean filter) {
        this.wrappedFilter = filter;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            wrappedFilter.doFilter(request, response, chain);
        } catch (Exception e) {
            ((HttpServletResponse) response).sendRedirect("access-denied?message=" + e.getLocalizedMessage());
        }
    }

    @Override
    public void destroy() {
        wrappedFilter.destroy();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        wrappedFilter.init(filterConfig);
    }
}