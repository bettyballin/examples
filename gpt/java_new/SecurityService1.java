import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import java.util.Collection;

@Component("securityService")
public class SecurityService1 {

    private final AccessDecisionManager accessDecisionManager;
    private final FilterInvocationSecurityMetadataSource securityMetadataSource;

    @Autowired
    public SecurityService1(AccessDecisionManager accessDecisionManager,
                           FilterInvocationSecurityMetadataSource securityMetadataSource) {
        this.accessDecisionManager = accessDecisionManager;
        this.securityMetadataSource = securityMetadataSource;
    }

    public boolean hasAccess(String url) throws Exception {
        FilterInvocation fi = new FilterInvocation(url, "GET", new MockSecurityFilterChain());
        Collection<ConfigAttribute> attributes = securityMetadataSource.getAttributes(fi);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        try {
            accessDecisionManager.decide(authentication, fi, attributes);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // A mock SecurityFilterChain for use in this example
    private static class MockSecurityFilterChain implements org.springframework.security.web.SecurityFilterChain {
        @Override
        public boolean matches(javax.servlet.http.HttpServletRequest request) {
            return false;
        }

        @Override
        public java.util.List<javax.servlet.Filter> getFilters() {
            return null;
        }
    }
}