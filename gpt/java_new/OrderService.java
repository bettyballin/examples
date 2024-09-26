import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import java.util.List;

public class OrderService {

    @PreAuthorize("hasRole('ADMIN') or @securityService.isOwner(#id)")
    public List<Order> getUserOrders(Long id) {
        // implement the logic to return orders
        return null; // Replace with actual implementation
    }
}

@Service
class SecurityService {

    public boolean isOwner(Long userId) {
        String currentUserId = getCurrentUserId();
        return currentUserId.equals(String.valueOf(userId));
    }

    private String getCurrentUserId() {
        // Your existing logic to get the user ID from JWT
        return ""; // Replace with actual implementation
    }
}

class Order {
    // Order class implementation
}