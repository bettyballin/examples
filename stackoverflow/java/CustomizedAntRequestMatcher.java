import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import javax.servlet.http.HttpServletRequest;

public class CustomizedAntRequestMatcher implements RequestMatcher {
    private AntPathRequestMatcher antPathRequestMatcher;

    public CustomizedAntRequestMatcher(String pattern) {
        this.antPathRequestMatcher = new AntPathRequestMatcher(pattern);
    }

    @Override
    public boolean matches(HttpServletRequest request) {
        return antPathRequestMatcher.matches(request);
    }
}