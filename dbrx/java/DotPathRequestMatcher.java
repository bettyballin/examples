import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

public class DotPathRequestMatcher implements RequestMatcher {
    private final AntPathRequestMatcher antPathRequestMatcher;

    public DotPathRequestMatcher(String pattern) {
        // Use the same pattern as in Spring Security configuration
        // but replace dots with wildcards.
        String dotReplacedPattern = pattern.replace(".", "**");
        this.antPathRequestMatcher = new AntPathRequestMatcher(dotReplacedPattern, null);
    }

    @Override
    public boolean matches(HttpServletRequest request) {
        return antPathRequestMatcher.matches(request);
    }
}