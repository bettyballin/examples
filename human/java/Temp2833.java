import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.util.matcher.RequestMatcher;
import javax.servlet.http.HttpServletRequest;

public class Temp2833 {

    public static void main(String[] args) throws Exception {
        HttpSecurity httpSecurity = createHttpSecurity();
        httpSecurity.authorizeRequests()
                    .requestMatchers(new MyRequestMatcher())
                    .permitAll();
    }

    // Dummy method to create HttpSecurity instance
    private static HttpSecurity createHttpSecurity() throws Exception {
        return new HttpSecurity(null, null, null, null, null, null, null);
    }

    // Custom RequestMatcher implementation
    static class MyRequestMatcher implements RequestMatcher {
        @Override
        public boolean matches(HttpServletRequest request) {
            // Implement your matching logic here
            return true; // For example, permit all requests
        }
    }
}