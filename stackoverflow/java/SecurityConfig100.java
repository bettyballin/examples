// Assuming the following imports and that MyRequestMatcher implements RequestMatcher interface
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class SecurityConfig100 {

    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .requestMatchers(new MyRequestMatcher()).permitAll();
    }
    
    // Assuming MyRequestMatcher is something like this
    class MyRequestMatcher implements RequestMatcher {
        @Override
        public boolean matches(HttpServletRequest request) {
            // Custom logic to match requests
            return true;
        }
    }
}