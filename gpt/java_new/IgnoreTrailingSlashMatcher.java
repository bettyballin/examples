import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IgnoreTrailingSlashMatcher implements RequestMatcher {
    private final OrRequestMatcher orRequestMatcher;

    public IgnoreTrailingSlashMatcher(String... antPatterns) {
        List<RequestMatcher> matchers = Stream.of(antPatterns)
                .flatMap(pattern -> Stream.of(
                        new AntPathRequestMatcher(pattern),
                        new AntPathRequestMatcher(pattern.endsWith("/") ? pattern + "?" : pattern + "/?")
                ))
                .collect(Collectors.toList());
        orRequestMatcher = new OrRequestMatcher(matchers);
    }

    @Override
    public boolean matches(HttpServletRequest request) {
        return orRequestMatcher.matches(request);
    }
}