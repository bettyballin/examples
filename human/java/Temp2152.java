import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class Temp2152 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        System.out.println("This is a Spring Security configuration class.");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
            .requestMatchers(new MyInternalRequestMatcher());
    }

    private static class MyInternalRequestMatcher implements RequestMatcher {
        @Override
        public boolean matches(javax.servlet.http.HttpServletRequest request) {
            // Implement your matching logic here
            return false;
        }
    }
}