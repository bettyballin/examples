import java.util.List;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Temp319 {
    
    private static final Logger log = LoggerFactory.getLogger(Temp319.class);
    private TestRepository testRepository; // Assuming you have a TestRepository interface
    private AclService aclService; // Assuming you have an AclService interface

    public static void main(String[] args) {
        // You can initialize and call update method for testing purposes here
    }

    public void update(List<Test> tests) {
        // Iterate through the list of Test objects
        for (Test test : tests) {
            try {
                // Check if user has permission or role
                SecurityContext context = SecurityContextHolder.getContext();
                Authentication authentication = context.getAuthentication();
                boolean isPermitted = false;
                Object principal = authentication.getPrincipal();

                for (GrantedAuthority auth : authentication.getAuthorities()) {
                    if ("ROLE_ADMIN".equals(auth.getAuthority())) {
                        // User has ROLE_ADMIN
                        isPermitted = true;
                        break;
                    }

                    if (aclService.checkPermission((Principal) principal, test, BasePermission.WRITE)) {
                        // User has write permission
                        isPermitted = true;
                        break;
                    }
                }

                if (!isPermitted && !authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_SUPERADMIN"))) {
                    throw new AccessDeniedException("Access denied");
                }

                // Save the Test object
                testRepository.save(test);
                updateDeviceAcL(test);

            } catch (AccessDeniedException e) {
                log.error("User does not have permission to perform this action", e);
            }
        }
    }

    private void updateDeviceAcL(Test test) {
        // Your implementation here
    }
}

// Assuming you have the following interfaces and classes
interface TestRepository {
    void save(Test test);
}

interface AclService {
    boolean checkPermission(Principal principal, Test test, BasePermission permission);
}

class Test {
    // Your implementation here
}

class BasePermission {
    public static final BasePermission WRITE = new BasePermission();
}

class Principal {
    // Your implementation here
}