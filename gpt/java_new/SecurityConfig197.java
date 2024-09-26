import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig197urerAdapter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

@EnableWebSecurity
public class SecurityConfig197 extends WebSecurityConfig197urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .requestMatchers(new InternationalizationRequestMatcher()).permitAll()
                .anyRequest().authenticated();
    }

    private static class InternationalizationRequestMatcher implements RequestMatcher {
        @Override
        public boolean matches(HttpServletRequest request) {
            String langParam = request.getParameter("lang");
            return langParam != null && !langParam.isEmpty();
        }
    }
}