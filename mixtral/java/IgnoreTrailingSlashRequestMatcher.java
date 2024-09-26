import javax.servlet.http.HttpServletRequest;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class IgnoreTrailingSlashRequestMatcher implements RequestMatcher {

    private final AntPathMatcher antPatternParser = new AntPathMatcher();

    @Override
    public boolean matches(HttpServletRequest request) {
        String pathWithinApplication = ServletUriComponentsBuilder
                .fromContextPath(request).build().getPath();

        return this.antPatternParser
            .match("/some/endpoint", removeTrailingSlash(pathWithinApplication));
    }

    private static String removeTrailingSlash(String path) {
        if (path != null && path.length() > 1 && "/".equals(path.substring(path.length() - 1))) {
            return path.substring(0, path.length() - 1);
        } else {
            return path;
        }
    }
}