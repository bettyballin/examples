import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.config.http.SessionCreationPolicy;

@Order(2)
public class MicroserviceSecurityConfigurationHttpBasic extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().exceptionHandling()
                .authenticationEntryPoint(customAccessDeniedHandler())
                .and().headers().frameOptions().disable()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .requestMatcher(new BasicRequestMatcher())
                .authorizeRequests()
                .antMatchers("/api/**").authenticated()
                .and().httpBasic();
    }

    private AuthenticationEntryPoint customAccessDeniedHandler() {
        return new AuthenticationEntryPoint() {
            @Override
            public void commence(HttpServletRequest request, HttpServletResponse response,
                                 AuthenticationException authException) {
                // Custom response for access denied
            }
        };
    }

    private class BasicRequestMatcher implements RequestMatcher {
        @Override
        public boolean matches(HttpServletRequest httpRequest) {
            String auth = httpRequest.getHeader("Authorization");
            String requestUri = httpRequest.getRequestURI();
            String identifier = requestUri.substring(requestUri.lastIndexOf("/") + 1);

            if (auth != null && auth.startsWith("Basic") && identifier.equalsIgnoreCase("ABC")) {
                return false; // Redirect to OAuth2.0 for identifier ABC
            }
            return auth != null && auth.startsWith("Basic");
        }
    }
}