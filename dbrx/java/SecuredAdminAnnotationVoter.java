import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;

public class SecuredAdminAnnotationVoter implements AccessDecisionVoter<Object> {

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return attribute != null && "ROLE_ADMIN".equals(attribute.getAttribute());
    }

    @Override
    public int vote(Authentication authentication, Object object, java.util.Collection<ConfigAttribute> attributes) {
        for (ConfigAttribute attribute : attributes) {
            if (supports(attribute)) {
                return AccessDecisionVoter.ACCESS_GRANTED;
            }
        }
        return AccessDecisionVoter.ACCESS_DENIED;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}