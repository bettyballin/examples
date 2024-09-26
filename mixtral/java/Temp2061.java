import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

public class Temp2061 {

    public static void main(String[] args) {
        // Example main method content
        System.out.println("Application started");
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') || hasPermission(#id, 'READ_ORDER')")
    public List<Order> getOrders(@PathVariable Long id) {
        // Implement your logic to get orders here
        return null;
    }

    public boolean hasPermission(Authentication authentication, Object targetId, String permission) {
        if (authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"))) {
            return true;
        }

        User user = (User) authentication.getPrincipal();
        // Implement your logic to check permissions based on the provided logic
        return false;
    }
}

class Order {
    // Implement Order class here
}