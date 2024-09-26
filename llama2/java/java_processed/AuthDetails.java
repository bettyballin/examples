import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthDetails extends WebAuthenticationDetails {

    private AuthTarget authTarget;

    public AuthDetails(javax.servlet.http.HttpServletRequest request) {
        super(request);
    }

    public void setAuthTarget(AuthTarget authTarget) {
        this.authTarget = authTarget;
    }

    public AuthTarget getAuthTarget() {
        return this.authTarget;
    }
}

class AuthTarget {
    private String targetName;

    public AuthTarget(String targetName) {
        this.targetName = targetName;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }
}