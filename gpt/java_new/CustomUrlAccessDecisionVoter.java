import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;

import java.util.Collection;

public class CustomUrlAccessDecisionVoter implements AccessDecisionVoter<FilterInvocation> {

    @Override
    public int vote(Authentication authentication, FilterInvocation fi, Collection<ConfigAttribute> attributes) {
        String url = fi.getRequestUrl();
        String httpMethod = fi.getRequest().getMethod();
        
        // Your custom logic to decide access based on URL and HTTP method
        // ...

        return ACCESS_ABSTAIN; // Replace with ACCESS_GRANTED or ACCESS_DENIED as needed
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}