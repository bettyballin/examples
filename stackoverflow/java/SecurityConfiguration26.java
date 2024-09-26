import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class SecurityConfiguration26 {

    private static class MyInternalRequestMatcher implements RequestMatcher {
        @Override
        public boolean matches(HttpServletRequest request) {
            // Custom logic to match requests goes here
            return false;
        }
    }

    public void configure(WebSecurity web) {
        web.ignoring().requestMatchers(new MyInternalRequestMatcher());
    }
}