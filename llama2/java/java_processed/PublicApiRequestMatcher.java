import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Component
public class PublicApiRequestMatcher implements RequestMatcher {
    private static final String PUBLIC_API_PATTERN = "^/generate$|^/validate$";

    @Override
    public boolean matches(HttpServletRequest request) {
        String requestUrl = request.getRequestURI();
        return requestUrl.matches(PUBLIC_API_PATTERN);
    }
}