import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .antMatcher("/role/**")
            .anonymous().disable()
            .addFilterBefore(authFilter(), AbstractPreAuthenticatedProcessingFilter.class)
            .authorizeRequests()
                .antMatchers("/role/**").authenticated()
            .and()
            .exceptionHandling()
                .authenticationEntryPoint(failureMessageEntryPoint());
    }

    @Bean
    public LoginUrlAuthenticationEntryPoint failureMessageEntryPoint() {
        return new LoginUrlAuthenticationEntryPoint("/message.jsp");
    }

    @Bean
    public AbstractPreAuthenticatedProcessingFilter authFilter() throws Exception {
        AbstractPreAuthenticatedProcessingFilter filter = new AbstractPreAuthenticatedProcessingFilter() {
            @Override
            protected Object getPreAuthenticatedPrincipal(javax.servlet.http.HttpServletRequest request) {
                return null; // Custom logic for pre-authentication
            }

            @Override
            protected Object getPreAuthenticatedCredentials(javax.servlet.http.HttpServletRequest request) {
                return null; // Custom logic for pre-authentication
            }
        };
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return new ProviderManager(preAuthenticatedAuthenticationProvider());
    }

    @Bean
    public PreAuthenticatedAuthenticationProvider preAuthenticatedAuthenticationProvider() {
        PreAuthenticatedAuthenticationProvider provider = new PreAuthenticatedAuthenticationProvider();
        provider.setPreAuthenticatedUserDetailsService(token -> null); // Custom user details service
        return provider;
    }
}