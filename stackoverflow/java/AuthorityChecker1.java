import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component("authorityChecker")
public class AuthorityChecker1 {
    public boolean canShowSuppliers(Authentication authentication) {
        // Implement your logic to check if the user can show suppliers
        return true;
    }
}

@Component
public interface SupplierService {
    @PreAuthorize("@authorityChecker.canShowSuppliers(authentication)")
    Page<Supplier> getSuppliers();
}