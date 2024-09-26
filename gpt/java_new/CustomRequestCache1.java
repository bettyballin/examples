import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class CustomRequestCache1 extends HttpSessionRequestCache {
    @Override
    public void saveRequest(HttpServletRequest request, HttpServletResponse response) {
        if (getRequest(request, response) == null) {
            super.saveRequest(request, response);
        }
        // Otherwise, do not save the request as there's already one saved
    }
}

// Assuming this is part of a class with proper context
class SecurityConfiguration {
    protected void configure(HttpSecurity http) throws Exception {
        http
            .requestCache()
            .requestCache(new CustomRequestCache1());
        // Additional configuration here
    }
}