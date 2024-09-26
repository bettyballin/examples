import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.header.HeaderWriterFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.savedrequest.RequestCacheAwareFilter;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(
                authenticationTokenFilterBean(),
                UsernamePasswordAuthenticationFilter.class
        ).requestMatcher(new NegatedRequestMatcher(
                new AntPathRequestMatcher("/some_endpoint")
        ));
    }

    public FilterChainProxy authenticationTokenFilterBean() throws Exception {
        SecurityFilterChain chain = new SecurityFilterChain(
            new AntPathRequestMatcher("/some_endpoint"),
            new WebAsyncManagerIntegrationFilter(),
            new SecurityContextPersistenceFilter(),
            new HeaderWriterFilter(),
            new CsrfFilter(),
            new RequestCacheAwareFilter(),
            new SecurityContextHolderAwareRequestFilter(),
            new AnonymousAuthenticationFilter(),
            new SessionManagementFilter(),
            new ExceptionTranslationFilter(),
            new FilterSecurityInterceptor()
        );

        return new FilterChainProxy(new SecurityFilterChain[]{chain});
    }
}