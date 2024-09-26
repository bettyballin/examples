import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.util.AntPathMatcher;

public class AuthenticationTokenFilter extends OncePerRequestFilter {

    private static final String[] SECURED_PATHS = new String[]{"/api/**"};
    private final AntPathMatcher pathMatcher = new AntPathMatcher();

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        for (String path : SECURED_PATHS) {
            if (pathMatcher.match(path, request.getRequestURI())) {
                return false;
            }
        }
        return true;
    }
}