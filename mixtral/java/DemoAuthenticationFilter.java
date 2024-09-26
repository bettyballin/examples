import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    public DemoAuthenticationFilter() {
        super("/oauth/token");
    }

    @Override
    protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response) {
        return true;
    }

    // Implement your custom authentication logic here

}