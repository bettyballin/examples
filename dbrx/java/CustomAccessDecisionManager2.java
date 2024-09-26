import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.intercept.FilterInvocation;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomAccessDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
            throws AccessDeniedException, InsufficientAuthenticationException {

        // Extract the URL pattern from the current request.
        String urlPattern = ((FilterInvocation) object).getRequestUrl();

        // Use regular expressions or other string manipulation techniques to extract
        // any parameters you need. For example:
        Pattern pageNamePattern = Pattern.compile("/page/(\\w+)");
        Matcher matcher = pageNamePattern.matcher(urlPattern);
        if (matcher.matches()) {
            String pageName = matcher.group(1);

            // Check the user's permissions based on this extracted parameter.
            boolean hasPermission = authentication.getAuthorities().contains(new SimpleGrantedAuthority(pageName));
            if (!hasPermission) {
                throw new AccessDeniedException("Access is denied");
            }
        }
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }

    public static void main(String[] args) {
        // Example usage
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        FilterInvocation filterInvocation = new FilterInvocation("/page/admin", "GET", "HTTP/1.1");

        CustomAccessDecisionManager manager = new CustomAccessDecisionManager();
        try {
            manager.decide(authentication, filterInvocation, null);
            System.out.println("Access granted");
        } catch (AccessDeniedException | InsufficientAuthenticationException e) {
            System.out.println(e.getMessage());
        }
    }
}