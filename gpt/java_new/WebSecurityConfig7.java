import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig7urerAdapter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

@EnableWebSecurity
public class WebSecurityConfig7 extends WebSecurityConfig7urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // ... other configuration ...
            .authorizeRequests()
                .requestMatchers(new NegatedRequestMatcher("/xyz/**")).authenticated()
            // ... other configuration ...
            ;
    }

    private static class NegatedRequestMatcher implements RequestMatcher {
        private final RequestMatcher delegate;

        public NegatedRequestMatcher(String pattern) {
            this.delegate = new org.springframework.security.web.util.matcher.AntPathRequestMatcher(pattern);
        }

        @Override
        public boolean matches(HttpServletRequest request) {
            return !delegate.matches(request);
        }
    }
}