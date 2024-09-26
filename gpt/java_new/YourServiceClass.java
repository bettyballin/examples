import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.access.AccessDeniedException;

public class YourServiceClass {

    @Autowired
    private Environment env;

    public void method() throws AccessDeniedException {
        String roleName = env.getProperty("role.rolename");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_" + roleName))) {
            // business logic
        } else {
            throw new AccessDeniedException("User does not have the required role: " + roleName);
        }
    }
}