import java.util.List;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class AuditAuthorizationDecisionVoter implements AccessDecisionVoter<Object> {

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    public int vote(Authentication authentication, Object object, List<ConfigAttribute> attributes) {
        // Do audit logging here
        return ACCESS_GRANTED;
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }
}