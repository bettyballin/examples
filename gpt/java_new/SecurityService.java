import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class SecurityService {

    private final FilterSecurityInterceptor filterSecurityInterceptor;

    @Autowired
    public SecurityService(FilterSecurityInterceptor filterSecurityInterceptor) {
        this.filterSecurityInterceptor = filterSecurityInterceptor;
    }

    public Map<RequestMatcher, Collection<ConfigAttribute>> getUrlSecurityMapping() {
        FilterInvocationSecurityMetadataSource metadataSource = filterSecurityInterceptor.getSecurityMetadataSource();
        
        if (metadataSource instanceof AbstractRequestMatcherMapping) {
            AbstractRequestMatcherMapping requestMatcherMapping = (AbstractRequestMatcherMapping) metadataSource;
            return requestMatcherMapping.getRequestMap();
        }
        
        return new LinkedHashMap<>();
    }
}