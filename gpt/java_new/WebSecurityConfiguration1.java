import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration1 extends WebSecurityConfigurerAdapter {

    private static class ApiRequestMatcher implements RequestMatcher {
        @Override
        public boolean matches(HttpServletRequest request) {
            return request.getRequestURI().startsWith("/api/") && !request.getRequestURI().startsWith("/api/user");
        }
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        RequestMatcher privateApiMatcher = new ApiRequestMatcher();
        // You can apply the privateApiMatcher as part of your security configuration
        // e.g. http.requestMatcher(privateApiMatcher)...
    }
}