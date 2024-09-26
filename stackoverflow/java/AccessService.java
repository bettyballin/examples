import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Service;

@Service
public class AccessService {
    public boolean hasAccess(String requestURI) {
        // Implement your access logic
        return true;
    }
}

// Assuming this is within a configuration class that extends WebSecurityConfigurerAdapter
public class SecurityConfig {
    
    private final AccessService accessService;

    public SecurityConfig(AccessService accessService) {
        this.accessService = accessService;
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .anyRequest().access("@accessService.hasAccess(request.requestURI) and hasRole('USER')");
    }
}