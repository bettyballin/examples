import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class Temp360 {

    @Autowired
    private SecurityService securityService;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Temp360.class, SecurityServiceImpl.class);
        Temp360 temp = context.getBean(Temp360.class);
        temp.someMethod();
    }

    public void someMethod() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        boolean isAdmin = securityService.authenticationHasRole(auth, "ADMIN");
        System.out.println("Is Admin: " + isAdmin);
        // ...
    }
}

interface SecurityService {
    boolean authenticationHasRole(Authentication auth, String role);
}

@Service
class SecurityServiceImpl implements SecurityService {
    @Override
    public boolean authenticationHasRole(Authentication auth, String role) {
        return auth != null && auth.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(role));
    }
}