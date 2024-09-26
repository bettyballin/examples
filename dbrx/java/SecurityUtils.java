import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Component("securityUtils")
public class SecurityUtils {

    @Autowired
    private Environment environment;

    @Autowired
    private SecurityService securityService;

    public boolean hasRoleForActiveProfile(String rolePrefix) {
        String[] activeProfiles = environment.getActiveProfiles();
        if (activeProfiles.length > 0) {
            String activeProfile = activeProfiles[0];
            return securityService.hasRole(rolePrefix + "_" + activeProfile);
        } else {
            return false;
        }
    }
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("@securityUtils.hasRoleForActiveProfile('SOME')")
public @interface PreAuthorizeSome {
}

interface SecurityService {
    boolean hasRole(String role);
}

// Added implementation for SecurityService
@Service
public class SecurityServiceImpl implements SecurityService {
    @Override
    public boolean hasRole(String role) {
        // Implement logic to check if user has the given role
        return true; // Temporary implementation
    }
}