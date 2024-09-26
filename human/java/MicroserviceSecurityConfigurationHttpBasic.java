import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

@Configuration
@Order(2)
public class MicroserviceSecurityConfigurationHttpBasic extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
            .exceptionHandling(exceptionHandling -> exceptionHandling
                .authenticationEntryPoint(customAccessDeniedHandler()))
            .headers(headers -> headers.frameOptions().disable())
            .sessionManagement(sessionManagement -> sessionManagement
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .requestMatcher(new BasicRequestMatcher())
            .authorizeRequests(authorizeRequests -> authorizeRequests
                .antMatchers("/api/**").authenticated())
            .httpBasic();
    }

    private CustomAccessDeniedHandler customAccessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    private class BasicRequestMatcher implements RequestMatcher {
        @Override
        public boolean matches(HttpServletRequest httpRequest) {
            String auth = httpRequest.getHeader("Authorization");
            String requestUri = httpRequest.getRequestURI();
            String identifier = requestUri.substring(requestUri.lastIndexOf("/") + 1);

            if (auth != null && auth.startsWith("Basic") && identifier.equalsIgnoreCase("ABC")) {
                auth = null;
            }
            return (auth != null && auth.startsWith("Basic"));
        }
    }

    private class CustomAccessDeniedHandler implements AuthenticationEntryPoint {
        @Override
        public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        }
    }
}