import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Component
public class AuthDetails extends WebAuthenticationDetails {

    private final AuthTarget authTarget;

    // Inject the request object
    @Autowired
    public AuthDetails(HttpServletRequest request) {
        super(request);

        String targetParam = request.getParameter("target");
        if (targetParam == null) {
            throw new IllegalArgumentException("Target parameter is missing");
        }

        try {
            this.authTarget = AuthTarget.valueOf(targetParam);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid target parameter value");
        }

        if (!Arrays.asList(AuthTarget.values()).contains(this.authTarget)) {
            throw new IllegalArgumentException("Invalid target parameter value");
        }
    }

    public AuthTarget getAuthTarget() {
        return this.authTarget;
    }
}

enum AuthTarget {
    USER,
    ADMIN,
    GUEST
}