import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.security.config.http.SessionCreationPolicy;

import javax.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public CustomApiAuthenticationFilter apiAuthenticationFilter() {
        return new CustomApiAuthenticationFilter();
    }

    @Bean
    public CustomWebAuthenticationFilter webAuthenticationFilter() {
        return new CustomWebAuthenticationFilter();
    }

    @Order(1)
    @Configuration
    public static class ApiSecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private CustomApiAuthenticationFilter apiAuthenticationFilter;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/api/**")
                .addFilterAfter(apiAuthenticationFilter, AbstractPreAuthenticatedProcessingFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests().antMatchers("/api/**").authenticated();
        }
    }

    @Order(2)
    @Configuration
    public static class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private CustomWebAuthenticationFilter webAuthenticationFilter;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/web/**")
                .addFilterAfter(webAuthenticationFilter, AbstractPreAuthenticatedProcessingFilter.class)
                .authorizeRequests().antMatchers("/web/**").authenticated();
        }
    } 
}

// Dummy filter classes for the sake of a complete example
class CustomApiAuthenticationFilter extends AbstractPreAuthenticatedProcessingFilter {
    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        return null;
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        return null;
    }
}

class CustomWebAuthenticationFilter extends AbstractPreAuthenticatedProcessingFilter {
    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        return null;
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        return null;
    }
}