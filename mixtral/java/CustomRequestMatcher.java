import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.web.util.matcher.RequestMatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

public class CustomRequestMatcher implements RequestMatcher {
    @Override
    public boolean matches(HttpServletRequest httpServletRequest) {
        // Extract token from the request and return true if authorized
        String token = httpServletRequest.getParameter("token");
        return token != null && token.equals("authorizedToken");
    }
}

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyBean myBean;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http.authorizeRequests();

        for (RequestMatcher requestMatcher : getCustomMatchers()) {
            registry.requestMatchers(requestMatcher).access("@myBean.authorise()");
        }
    }

    private List<RequestMatcher> getCustomMatchers() {
        return Arrays.asList(new CustomRequestMatcher());
    }

}

// Mockup for MyBean class
public class MyBean {
    public boolean authorise() {
        // Implement your custom authorization logic here
        return true;
    }
}