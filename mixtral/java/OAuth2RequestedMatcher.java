import javax.servlet.http.HttpServletRequest;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class OAuth2RequestedMatcher implements RequestMatcher {
    @Override
    public boolean matches(HttpServletRequest httpServletRequest) {
        String authHeader = httpServletRequest.getHeader("Authorization");

        return (authHeader != null && authHeader.startsWith("Bearer"));
    }

    public static void main(String[] args) {
        // This is just a sample main method to demonstrate the class usage.
        // In a real scenario, this class would be used within a Spring Security configuration.
    }
}