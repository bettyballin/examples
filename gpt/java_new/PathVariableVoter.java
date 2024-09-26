import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;

import java.util.Collection;

public class PathVariableVoter implements AccessDecisionVoter<FilterInvocation> {

    private MyBean myBean;

    public PathVariableVoter(MyBean myBean) {
        this.myBean = myBean;
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }

    @Override
    public int vote(Authentication authentication, FilterInvocation fi, Collection<ConfigAttribute> attributes) {
        String url = fi.getRequest().getRequestURI();

        // Code to use the URL and make a decision based on myBean logic
        // Implementation details for extracting token and making decision are not provided in the snippet

        // Stub decision logic - to be replaced with actual decision logic
        return ACCESS_GRANTED; // or ACCESS_DENIED, ACCESS_ABSTAIN based on your logic
    }
}