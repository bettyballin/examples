import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Set;

public class CustomAccessDecisionVoter implements AccessDecisionVoter<Object> {

    private HttpServletResponse response; // Assume this is injected or set somehow

    @Override
    public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> attributes)
            throws AccessDeniedException {

        // Assume missingAuthorities and requiredRoles are defined and populated somewhere
        Set<String> missingAuthorities = Set.of(); // Replace with actual logic
        Set<String> requiredRoles = Set.of(); // Replace with actual logic

        if (missingAuthorities.size() > 0) {
            response.setHeader("Sec-RequiredAuthorities", StringUtils.collectionToCommaDelimitedString(requiredRoles));

            throw new AccessDeniedException("Access Denied due to missing authorities");
        }

        return ACCESS_GRANTED;
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}