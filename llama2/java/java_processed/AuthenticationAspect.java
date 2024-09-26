import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.GrantedAuthority;
import java.util.Map;
import java.util.Collection;

@Aspect
public class AuthenticationAspect {

    @Before("execution(* *(..))")
    public void beforeMethodExecution(JoinPoint joinPoint) {
        // Get the current authentication
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            // Create a new extended authentication object
            ExtendedAuthentication extendedAuth = new ExtendedAuthentication(auth, (Map<String, Object>) auth.getDetails());
            
            // Set the extended authentication as the current authentication
            SecurityContextHolder.getContext().setAuthentication(extendedAuth);
        }
    }
}

class ExtendedAuthentication implements Authentication {
    private final Authentication originalAuth;
    private final Map<String, Object> details;

    public ExtendedAuthentication(Authentication originalAuth, Map<String, Object> details) {
        this.originalAuth = originalAuth;
        this.details = details;
    }

    @Override
    public String getName() {
        return originalAuth.getName();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return originalAuth.getAuthorities();
    }

    @Override
    public Object getCredentials() {
        return originalAuth.getCredentials();
    }

    @Override
    public Object getDetails() {
        return details;
    }

    @Override
    public Object getPrincipal() {
        return originalAuth.getPrincipal();
    }

    @Override
    public boolean isAuthenticated() {
        return originalAuth.isAuthenticated();
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        originalAuth.setAuthenticated(isAuthenticated);
    }
}