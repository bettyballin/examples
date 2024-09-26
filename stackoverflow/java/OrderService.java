import org.springframework.security.access.prepost.PreAuthorize;
import java.util.List;

public class OrderService {

    @PreAuthorize("#id == principal?.id")
    public List<Order> ordersForUser(Integer id) {
        // do something
        return null;
    }
    
    // Assuming Order is defined elsewhere
    public class Order {
        // Order fields and methods
    }
}