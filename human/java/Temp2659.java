import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.ArrayList;
import java.util.List;

public class Temp2659 {

    public static void main(String[] args) {
        Temp2659 temp = new Temp2659();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Page<Supplier> suppliers = temp.getSuppliers(Pageable.unpaged());
        suppliers.forEach(supplier -> System.out.println(supplier.getName()));
    }

    @PreAuthorize("@authorityChecker.canShowSuppliers(authentication)")
    public Page<Supplier> getSuppliers(Pageable pageable) {
        List<Supplier> supplierList = new ArrayList<>();
        supplierList.add(new Supplier("Supplier1"));
        supplierList.add(new Supplier("Supplier2"));
        return new PageImpl<>(supplierList, pageable, supplierList.size());
    }
}

class Supplier {
    private String name;

    public Supplier(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class AuthorityChecker {
    public boolean canShowSuppliers(Authentication authentication) {
        // Add your logic to check if the user has the authority to view suppliers
        return true;
    }
}