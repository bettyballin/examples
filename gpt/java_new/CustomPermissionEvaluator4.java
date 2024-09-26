import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class CustomPermissionEvaluator4 {

    public boolean hasSupplierAccess(Authentication authentication) {
        if (authentication == null || !(authentication.getPrincipal() instanceof User)) {
            return false;
        }

        User user = (User) authentication.getPrincipal();
        Role userRole = user.getRole();
        
        return userRole.isShowSuppliers();
    }
}