import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.bind.annotation.RequestMethod;

public class Temp1187 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Spring Boot application would typically start here
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").permitAll() // Example request matcher
                .and()
                .csrf().disable(); // Example configuration
    }

    private static class MethodTypeRequestMatcher implements RequestMatcher {
        private final RequestMethod method;

        public MethodTypeRequestMatcher(RequestMethod method) {
            this.method = method;
        }

        @Override
        public boolean matches(javax.servlet.http.HttpServletRequest request) {
            return method.name().equalsIgnoreCase(request.getMethod());
        }
    }
}