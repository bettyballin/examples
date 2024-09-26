import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class JwtAuthenticationTokenFilter extends BasicAuthenticationFilter {

    private static RequestMatcher customRequestMatcher;

    static {
        // Initialize customRequestMatcher here
    }

    public JwtAuthenticationTokenFilter() {
        super(customRequestMatcher);
    }
}