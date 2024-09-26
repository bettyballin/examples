import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.List;

@Component
public class CustomAccessVoter implements AccessDecisionVoter<FilterInvocation> {

    @Autowired
    private DataSource dataSource;

    // ... other methods and dependencies

    @Override
    public int vote(Authentication authentication, FilterInvocation fi, Collection<ConfigAttribute> attributes) {
        String url = fi.getRequestUrl();

        List<String> allowedRolesForResource = getAllowedRolesFromDatabaseBasedOnURL(url);

        for (GrantedAuthority authority : authentication.getAuthorities()) {
            if (allowedRolesForResource.contains(authority.getAuthority())) {
                return ACCESS_GRANTED;
            }
        }

        // If no matching role found access is denied
        return ACCESS_DENIED;
    }

    private List<String> getAllowedRolesFromDatabaseBasedOnURL(String url) {
        // Implementation to fetch roles from database based on the URL
        // This is a placeholder for the actual database call
        return List.of(); // Replace with actual database query result
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