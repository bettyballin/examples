import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpMethod;

public class CustomFilter2 {
    private final RequestMatcher uriMatcher = new AntPathRequestMatcher("/api/v0/auth/login", HttpMethod.GET.name());

    protected boolean shouldNotFilter(HttpServletRequest request) {
        return uriMatcher.matches(request);
    }
}