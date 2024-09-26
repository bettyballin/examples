import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import javax.servlet.http.HttpServletRequest;

public class CaseInsensitiveAntPathRequestMatcher extends AntPathRequestMatcher {
    public CaseInsensitiveAntPathRequestMatcher(String pattern) {
        super(pattern);
    }
    
    public CaseInsensitiveAntPathRequestMatcher(String pattern, String httpMethod) {
        super(pattern, httpMethod);
    }

    @Override
    public boolean matches(HttpServletRequest request) {
        String url = request.getRequestURI().toLowerCase();
        String method = request.getMethod();
        AntPathRequestMatcher caseInsensitiveMatcher = 
            new AntPathRequestMatcher(getPattern(), getHttpMethod());
        return caseInsensitiveMatcher.matches(request);
    }
}