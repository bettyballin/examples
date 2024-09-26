import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.AuthenticationTrustResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomTrustResolver implements AuthenticationTrustResolver {
    @Override
    public boolean isTrusted(HttpServletRequest request, HttpServletResponse response, Object o) throws AccessDeniedException, IOException {
        // Allow all requests
        return true;
    }

    @Override
    public boolean isAnonymous(HttpServletRequest request) {
        // Always return false
        return false;
    }

    @Override
    public boolean isRememberMe(HttpServletRequest request) {
        // Always return false
        return false;
    }
}