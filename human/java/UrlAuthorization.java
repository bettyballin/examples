import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.http.HttpMethod;

import java.util.Collection;

public final class UrlAuthorization {
    private static final Logger LOG = LoggerFactory.getLogger(UrlAuthorization.class);

    private final FilterInvocationSecurityMetadataSource securityMetadataSource;
    private final AccessDecisionManager accessDecisionManager;

    public UrlAuthorization(FilterInvocationSecurityMetadataSource securityMetadataSource,
                            AccessDecisionManager accessDecisionManager) {

        this.securityMetadataSource = securityMetadataSource;
        this.accessDecisionManager = accessDecisionManager;
    }

    public boolean isAccessible(String url) {
        Authentication authentication = AuthUtils.getAuthentication();

        FilterInvocation invocation = new FilterInvocation(null, url, HttpMethod.GET.name());
        Collection<ConfigAttribute> attributes = securityMetadataSource
                .getAttributes(invocation);

        try {
            this.accessDecisionManager.decide(authentication, invocation, attributes);

        } catch (AccessDeniedException e) {
            LOG.trace("Not allowed to access URL: {}", url, e);
            return false;
        }
        return true;
    }
}