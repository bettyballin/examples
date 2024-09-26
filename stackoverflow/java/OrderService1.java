import org.springframework.security.access.prepost.PreAuthorize;
import java.util.List;

public class OrderService1 {

    @PreAuthorize("@yourBean.hasPermission(principal, #id, 'admin')")
    public List<Order> ordersForUsers(Integer id) {
        // do something
        return null; // Replace with actual implementation
    }
    
    // Assuming Order class exists
    public static class Order {
        // Order class implementation
    }
    
    // Assuming yourBean is a bean with hasPermission method
    public static class YourBean {
        public boolean hasPermission(Object principal, Integer id, String role) {
            // Implement permission logic
            return true; // Replace with actual permission logic
        }
    }
}