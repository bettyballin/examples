import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthenticationProvider authProvider;

    // Admin login configuration
    public HttpSecurity adminHttp(HttpSecurity http) throws Exception {
        return http
            .antMatcher("/admin/**")
                .authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/admin/login").permitAll();

    }

    // User login configuration
    public HttpSecurity userHttp(HttpSecurity http) throws Exception {
        return http
            .antMatcher("/user/**")
                .authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/user/login").permitAll();

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Add the admin and user configurations to the filter chain
        http.apply(new DelegatingHttpSecurityConfigurer<>(adminHttp(http)))
            .and()
            .apply(new DelegatingHttpSecurityConfigurer<>(userHttp(http)));
    }

    private static class DelegatingHttpSecurityConfigurer<T extends HttpSecurityBuilder<T>> extends AbstractHttpConfigurer<DelegatingHttpSecurityConfigurer<T>, T> {
        private final HttpSecurityConfigurer<T> delegate;

        DelegatingHttpSecurityConfigurer(HttpSecurityConfigurer<T> delegate) {
            this.delegate = delegate;
        }

        @Override
        public void configure(T http) throws Exception {
            this.delegate.configure(http);
        }
    }

    private interface HttpSecurityConfigurer<T extends HttpSecurityBuilder<T>> {
        void configure(T http) throws Exception;
    }
}