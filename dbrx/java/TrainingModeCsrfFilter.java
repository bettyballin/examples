import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.csrf.CsrfTokenRepository;

public class TrainingModeCsrfFilter extends CsrfFilter {

    private final RequestMatcher requireCsrfProtectionMatcher;
    private final AccessDeniedHandler accessDeniedHandler;

    public TrainingModeCsrfFilter(RequestMatcher requireCsrfProtectionMatcher, AccessDeniedHandler accessDeniedHandler) {
        super(new TrainingModeCsrfTokenRepository());
        this.requireCsrfProtectionMatcher = requireCsrfProtectionMatcher;
        this.accessDeniedHandler = accessDeniedHandler;
    }

    // ... other methods ...
}

class TrainingModeCsrfTokenRepository implements CsrfTokenRepository {
    // Implementation of TrainingModeCsrfTokenRepository 
}