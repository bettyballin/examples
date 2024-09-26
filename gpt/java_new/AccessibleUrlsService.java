import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.security.access.method.MethodSecurityMetadataSource;

import java.lang.reflect.Method;
import java.util.*;

@Component
public class AccessibleUrlsService {

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Autowired
    private MethodSecurityMetadataSource securityMetadataSource;

    public List<String> getAccessibleUrlsForCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return Collections.emptyList();
        }

        Set<String> accessibleUrls = new HashSet<>();
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethods();
        for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : handlerMethods.entrySet()) {
            HandlerMethod handlerMethod = entry.getValue();
            Method method = handlerMethod.getMethod();
            Collection<ConfigAttribute> attributes = securityMetadataSource.getAttributes(method, method.getDeclaringClass());
            
            if (isMethodAccessibleForCurrentUser(authentication, attributes)) {
                RequestMappingInfo requestMappingInfo = entry.getKey();
                Set<String> patterns = requestMappingInfo.getPatternsCondition().getPatterns();
                accessibleUrls.addAll(patterns);
            }
        }

        return new ArrayList<>(accessibleUrls);
    }

    private boolean isMethodAccessibleForCurrentUser(Authentication authentication, Collection<ConfigAttribute> attributes) {
        if (attributes == null) {
            return true;
        }

        for (ConfigAttribute attribute : attributes) {
            boolean isAccessible = authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .anyMatch(grantedAuthority -> grantedAuthority.equals(attribute.getAttribute()));
            if (!isAccessible) {
                return false;
            }
        }

        return true;
    }
}